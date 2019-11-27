package com.tu.duduse.common.model.dto;

import lombok.Data;

@Data
public class SpiderUrlDto {
    private String name;
    private String url;
    private String xpath;
    private String charset;
    private String type;
    private String status;
}
