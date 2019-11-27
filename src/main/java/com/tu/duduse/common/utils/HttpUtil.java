package com.tu.duduse.common.utils;

import com.tu.duduse.common.model.qo.HttpQo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.selector.PlainText;
import us.codecraft.webmagic.utils.HttpConstant;
import us.codecraft.webmagic.utils.UrlUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName HttpUtil
 * @Description
 * @Date 2019/11/7 10:58
 */
@Slf4j
public class HttpUtil {
    private static final int KEEP_ALIVE = 2000;
    private static Map<String, HttpClient> httpClients = new HashMap<>();
    private static ConnectionKeepAliveStrategy keepAliveStrat = new DefaultConnectionKeepAliveStrategy() {
        @Override
        public long getKeepAliveDuration(
                HttpResponse response,
                HttpContext context) {
            long keepAlive = super.getKeepAliveDuration(response, context);
            if (keepAlive == -1) {
                keepAlive = KEEP_ALIVE;
            }
            return keepAlive;
        }
    };

    private HttpUtil() {

    }

    private static RequestConfig requestConfig = RequestConfig.custom()
            .setRedirectsEnabled(true)
            .setSocketTimeout(3000)
            .setConnectTimeout(3000)
            .setConnectionRequestTimeout(5000)
            .build();
    private static PoolingHttpClientConnectionManager cm;

    static {
        try {
            SSLContext sslcontext = createIgnoreVerifySSL();
            Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext))
                    .build();
            cm = new PoolingHttpClientConnectionManager(reg);
            cm.setDefaultMaxPerRoute(32);
            cm.setMaxTotal(200);
        } catch (Exception e) {
            log.error("初始化httpclinet错误：", e);
        }
    }

    /**
     * @description 对外提供接口
     * @author gang.tu
     * @date 2019/11/7 14:24
     * @return: us.codecraft.webmagic.Page
     */
    public static Page getPage(HttpQo httpQo) throws IOException {
        RequestBuilder requestBuilder = selectRequestMethod(httpQo).setUri(httpQo.getUrl());
        if (httpQo.getHeaders() != null) {
            for (Map.Entry<String, String> headerEntry : httpQo.getHeaders().entrySet()) {
                requestBuilder.addHeader(headerEntry.getKey(), headerEntry.getValue());
            }
        }
        requestBuilder.setConfig(requestConfig);
        requestBuilder.build();
        HttpResponse response = getHttpClient(httpQo).execute(requestBuilder.build());
        return handleResponse(httpQo, response);
    }

    private static CloseableHttpClient createHttpClient(boolean keepAlive) {
        HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(cm);
        if (keepAlive) {
            httpClientBuilder.setKeepAliveStrategy(keepAliveStrat);
        }
        return httpClientBuilder.build();
    }

    private static HttpClient getHttpClient(HttpQo httpQo) {
        String name = httpQo.getWebName();
        boolean keepAlive = httpQo.isKeepAlive();
        if (name == null) {
            return createHttpClient(keepAlive);
        }
        HttpClient httpClient;
        httpClient = httpClients.get(name);
        if (httpClient == null) {
            synchronized (HttpUtil.class) {
                httpClient = httpClients.get(name);
                if (httpClient == null) {
                    httpClient = createHttpClient(keepAlive);
                    httpClients.put(name, httpClient);
                }
            }
        }
        return httpClient;
    }

    private static Page handleResponse(HttpQo httpQo, HttpResponse httpResponse) throws IOException {
        String content = getContent(httpQo.getCharset(), httpResponse);
        Page page = new Page();
        page.setRawText(content);
        page.setUrl(new PlainText(httpQo.getUrl()));
        page.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        page.setRequest(new Request(httpQo.getUrl()));
        return page;
    }

    private static String getContent(String charset, HttpResponse httpResponse) throws IOException {
        if (charset == null || "".equals(charset)) {
            byte[] contentBytes = IOUtils.toByteArray(httpResponse.getEntity().getContent());
            String htmlCharset = getHtmlCharset(httpResponse, contentBytes);
            if (htmlCharset != null) {
                return new String(contentBytes, htmlCharset);
            } else {
                return new String(contentBytes);
            }
        } else {
            return IOUtils.toString(httpResponse.getEntity().getContent(), charset);
        }
    }

    private static String getHtmlCharset(HttpResponse httpResponse, byte[] contentBytes) throws IOException {
        String charset = "";
        Charset defaultCharset = Charset.defaultCharset();
        String content = new String(contentBytes, defaultCharset.name());
        if (StringUtils.isNotEmpty(content)) {
            Document document = Jsoup.parse(content);
            Elements links = document.select("meta");
            for (Element link : links) {
                String metaContent = link.attr("content");
                String metaCharset = link.attr(CHAR_SET);
                if (metaContent.indexOf(CHAR_SET) != -1) {
                    metaContent = metaContent.substring(metaContent.indexOf(CHAR_SET), metaContent.length());
                    charset = metaContent.split("=")[1];
                    break;
                } else if (StringUtils.isNotEmpty(metaCharset)) {
                    charset = metaCharset;
                    break;
                }
            }
        }
        if (charset != null && !"".equals(charset)) {
            return charset;
        }

        String value = httpResponse.getEntity().getContentType().getValue();
        charset = UrlUtils.getCharset(value);
        if (StringUtils.isNotBlank(charset)) {
            return charset;
        }

        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";
            return charset;
        }
        return charset;
    }

    private static RequestBuilder selectRequestMethod(HttpQo httpQo) {
        String method = httpQo.getMethod();
        if (method == null || method.equalsIgnoreCase(HttpConstant.Method.GET)) {
            RequestBuilder requestBuilder = RequestBuilder.get();
            return requestBuilder;
        } else if (method.equalsIgnoreCase(HttpConstant.Method.POST)) {
            RequestBuilder requestBuilder = RequestBuilder.post();
            List<NameValuePair> valuePairs = convertMap2PostParams(httpQo.getPostParams());
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
            requestBuilder.setEntity(urlEncodedFormEntity);
            return requestBuilder;
        } else if (method.equalsIgnoreCase(HttpConstant.Method.HEAD)) {
            return RequestBuilder.head();
        } else if (method.equalsIgnoreCase(HttpConstant.Method.PUT)) {
            return RequestBuilder.put();
        } else if (method.equalsIgnoreCase(HttpConstant.Method.DELETE)) {
            return RequestBuilder.delete();
        } else if (method.equalsIgnoreCase(HttpConstant.Method.TRACE)) {
            return RequestBuilder.trace();
        }
        throw new IllegalArgumentException("Illegal HTTP Method " + method);
    }

    private static List<NameValuePair> convertMap2PostParams(Map<String, String> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        if (keys.isEmpty()) {
            return new ArrayList<>();
        }
        int keySize = keys.size();
        List<NameValuePair> data = new LinkedList<NameValuePair>();
        for (int i = 0; i < keySize; i++) {
            String key = keys.get(i);
            String value = params.get(key);
            data.add(new BasicNameValuePair(key, value));
        }
        return data;
    }


    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

    private static final String CHAR_SET = "charset";
}
