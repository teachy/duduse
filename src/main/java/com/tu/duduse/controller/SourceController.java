package com.tu.duduse.controller;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.dto.SourcesDto;
import com.tu.duduse.service.SourceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.tu
 * @ClassName SourceController
 * @Description
 * @Date 2019/11/25 15:22
 */
@RestController
@RequestMapping("/source")
@Slf4j
public class SourceController {
    private final SourceService sourceService;

    @Autowired
    SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @ApiOperation(value = "新增本地资源信息", notes = "本地资源信息")
    @PostMapping("/insertLocal")
    public ResultData insertTools(@RequestBody @Validated SourcesDto sourcesDto) {
        return sourceService.insertSource(sourcesDto);
    }
}