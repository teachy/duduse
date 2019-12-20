package com.tu.duduse.controller;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.bo.SpiderUrlBo;
import com.tu.duduse.service.SpiderService;
import com.tu.duduse.service.SpiderUrlService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.tu
 * @ClassName TestSpiderController
 * @Description
 * @Date 2019/11/14 21:08
 */
@RestController
@RequestMapping("/testUrl")
@Slf4j
public class TestSpiderController {
    final SpiderUrlController spiderUrlController;
    final SpiderService spiderService;

    @Autowired
    SpiderUrlService spiderUrlService;
    @Autowired
    TestSpiderController( SpiderUrlController spiderUrlController, SpiderService spiderService) {
        this.spiderUrlController = spiderUrlController;
        this.spiderService = spiderService;
    }


    @ApiOperation(value = "新增测试网站", notes = "测试")
    @PostMapping("/addTestUrl")
    public ResultData addTestUrl(@RequestBody @Validated SpiderUrlBo spiderUrlBo) {
        log.info("新增测试网站:{}", spiderUrlBo);
        return spiderUrlService.insertTestSpiderUrl(spiderUrlBo);
    }

    @ApiOperation(value = "测试新增的网站", notes = "网站列表")
    @GetMapping("/querySourcesByTest")
    public ResultData querySourcesByTest(@RequestParam String query) {
        return new ResultData<>(spiderService.queryByTestSpider(query));
    }

    @ApiOperation(value = "确认添加测试网站", notes = "测试")
    @GetMapping("/insertTestUrl")
    public ResultData insertTestUrl() {
        SpiderUrlBo spiderUrlBo = spiderUrlService.insertTestUrl();
        return spiderUrlController.insertUrl(spiderUrlBo);
    }
}