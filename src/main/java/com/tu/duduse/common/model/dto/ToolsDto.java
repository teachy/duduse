package com.tu.duduse.common.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ToolsDto {
    private String user = "admin";
    @NotNull
    private String name;
    @NotNull
    private String url;
    @NotNull
    private String description;
}
