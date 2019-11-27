package com.tu.duduse.common.model.qo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIUtils;

import java.net.URI;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName HttpQo
 * @Description
 * @Date 2019/11/7 11:29
 */
@Data
@Slf4j
public class HttpQo {
    private String url;
    private String webName;
    private boolean keepAlive = false;
    private String method = "get";
    private String charset;
    private Map<String, String> postParams = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();

    public HttpQo(String url, String query, String charset) {
        try {
            this.setUrl(MessageFormat.format(url, URLEncoder.encode(query, charset)));
            this.getHeaders().put("Host", URIUtils.extractHost(new URI(this.getUrl())).getHostName());
            this.getHeaders().put("User-Agent", USER_AGENT);
        } catch (Exception e) {
            log.error("初始化url出错：{}", this.getUrl(), e);
        }
    }

    public HttpQo(String url, String query) {
         this(url, query, "utf-8");
    }

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36";
}