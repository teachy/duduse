package com.tu.duduse.common.model.qo;

import com.tu.duduse.common.model.bo.SpiderUrlBo;
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
    private boolean keepAlive = false;
    private String method = "get";
    private String charset;
    private Map<String, String> postParams = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private String xpath;
    private String name;
    private boolean redirect;

    public HttpQo(String query, SpiderUrlBo spiderUrlBo) {
        try {
            this.setXpath(spiderUrlBo.getXpath());
            this.setName(spiderUrlBo.getName());
            if (spiderUrlBo.getRedirect().equals("0")) {
                this.setRedirect(false);
            } else {
                this.setRedirect(true);
            }
            this.setUrl(MessageFormat.format(spiderUrlBo.getUrl(), URLEncoder.encode(query, spiderUrlBo.getCharset())));
            this.getHeaders().put("Host", URIUtils.extractHost(new URI(this.getUrl())).getHostName());
            this.getHeaders().put("User-Agent", USER_AGENT);
        } catch (Exception e) {
            log.error("初始化url出错：{}", this.getUrl(), e);
        }
    }

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36";
}