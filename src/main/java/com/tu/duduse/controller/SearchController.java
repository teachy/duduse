package com.tu.duduse.controller;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.service.SpiderService;
import com.tu.duduse.spider.all.BaseSpider;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gang.tu
 * @ClassName SearchController
 * @Date 2019/11/5 10:54
 */
@CrossOrigin
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {
    final SpiderService spiderService;

    @Autowired
    SearchController(SpiderService spiderService) {
        this.spiderService = spiderService;
    }

    @ApiOperation(value = "根据关键词聚合网站信息", notes = "查询列表")
    @GetMapping("/querySourcesByWebs")
    public ResultData querySourcesByWebs(@RequestParam String query, @RequestParam(required = false) String type, HttpServletRequest request) {
        if (query.length() > MAX_LENGTH) {
            return new ResultData("未找到数据");
        }
        return new ResultData<>(spiderService.queryBySpider(type, query, request));
    }

    @ApiOperation(value = "查询全部类型", notes = "查询列表")
    @GetMapping("/queryAllType")
    public ResultData queryAllType() {
        return new ResultData<>(BaseSpider.allType);
    }

    private static final int MAX_LENGTH = 60;
}