package com.tu.duduse.controller;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.dto.ToolsDto;
import com.tu.duduse.service.ToolsService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.tu
 * @ClassName ToolsController
 * @Description
 * @Date 2019/11/19 17:32
 */
@RestController
@RequestMapping("/tools")
@Slf4j
public class ToolsController {
    final ToolsService toolsService;

    @Autowired
    ToolsController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    @ApiOperation(value = "查询工具信息", notes = "工具信息")
    @GetMapping("/getTools")
    public ResultData getTools() {
        return new ResultData(toolsService.queryToolsDtos());
    }

    @ApiOperation(value = "新增工具信息", notes = "工具信息")
    @PostMapping("/insertTools")
    public ResultData insertTools(@RequestBody @Validated ToolsDto toolsDto) {
        return toolsService.insertTools(toolsDto);
    }

}