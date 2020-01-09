package com.tu.duduse.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceTypeDto {
    private String type;
    private String typeValue;
    private String describe;
}