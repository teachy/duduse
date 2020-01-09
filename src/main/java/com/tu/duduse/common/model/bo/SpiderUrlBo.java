package com.tu.duduse.common.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SpiderUrlBo {
    @ApiModelProperty(hidden = true)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    @NotNull
    private String xpath;
    @NotNull
    private String type;
    @ApiModelProperty(hidden = true)
    private String charset = "utf-8";
    @ApiModelProperty(hidden = true)
    private String status = "1";
    @ApiModelProperty(hidden = true)
    private Integer errorNum = 0;
    private String redirect = "0";
}
