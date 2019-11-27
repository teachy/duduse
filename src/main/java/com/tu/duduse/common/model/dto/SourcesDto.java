package com.tu.duduse.common.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SourcesDto {
  @NotNull
  private String name;
  @NotNull
  private String url;
  private String pass;
  private String description;
}
