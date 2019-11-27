package com.tu.duduse.service;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.dto.SourcesDto;

/**
 * @author gang.tu
 * @ClassName SourceService
 * @Description
 * @Date 2019/11/25 15:23
 */
public interface SourceService {
    ResultData insertSource(SourcesDto sourcesDto);
}