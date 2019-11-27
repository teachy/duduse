package com.tu.duduse.controller;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.bo.SpiderUrlBo;
import com.tu.duduse.service.SpiderUrlService;
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
 * @ClassName SpiderUrlController
 * @Description
 * @Date 2019/11/14 15:58
 */
@RestController
@RequestMapping("/spiderUrl")
@Slf4j
public class SpiderUrlController {
    final SpiderUrlService spiderUrlService;

    @Autowired
    SpiderUrlController(SpiderUrlService spiderUrlService) {
        this.spiderUrlService = spiderUrlService;
    }

    @ApiOperation(value = "直接新增网站而不走测试流程", notes = "网站列表")
    @PostMapping("/insertUrl")
    public ResultData insertUrl(@RequestBody @Validated SpiderUrlBo spiderUrlBo) {
        log.info("新增网站:{}", spiderUrlBo);
        return spiderUrlService.insertSpiderUrl(spiderUrlBo);
    }

}