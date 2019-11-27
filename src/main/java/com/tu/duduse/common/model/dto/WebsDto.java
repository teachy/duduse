package com.tu.duduse.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gang.tu
 * @ClassName WebsDto
 * @Description
 * @Date 2019/11/7 14:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsDto {
    private String webName;
    private String size = "1";
    private String pass = "";
    private String url;

   public WebsDto(String webName,String size,String url){
        this.webName = webName;
        this.size = size;
        this.url = url;
    }
}