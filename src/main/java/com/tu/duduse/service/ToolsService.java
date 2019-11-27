package com.tu.duduse.service;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.dto.ToolsDto;

import java.util.List;

/**
 * @author gang.tu
 * @ClassName ToolsService
 * @Description
 * @Date 2019/11/19 17:33
 */
public interface ToolsService {
    List<ToolsDto> queryToolsDtos();

    ResultData insertTools(ToolsDto toolsDto);
}