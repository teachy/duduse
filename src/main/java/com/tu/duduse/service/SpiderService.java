package com.tu.duduse.service;

import com.tu.duduse.common.model.dto.WebsDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author gang.tu
 * @ClassName SpiderService
 * @Description
 * @Date 2019/11/7 16:18
 */
public interface SpiderService {
    List<WebsDto> queryBySpider(String type, String query, HttpServletRequest request);
    List<WebsDto> queryByTestSpider(String query);
}
