package com.tu.duduse.spider;

import com.tu.duduse.common.model.bo.SpiderUrlBo;
import com.tu.duduse.common.model.dto.WebsDto;

import java.util.List;

/**
 * @author gang.tu
 * @ClassName SpiderWorkService
 * @Description
 * @Date 2019/11/14 20:22
 */
public interface SpiderWorkService {
    /**
     * @description 查询数据入口，数据来源：爬虫，工具表，数据表
     * @author gang.tu
     * @date 2019/11/25 15:09
     * @Param type:数据类型
     * @Param query:查询条件
     * @return: java.util.List<com.tu.duduse.common.model.dto.WebsDto>
     */
    List<WebsDto> queryBySpider(String type, String query);

    /**
     * @description 新增测试爬虫
     * @author gang.tu
     * @date 2019/11/25 15:10
     */
    boolean insertTestSpiderUrl(SpiderUrlBo spiderUrlBo);

    /**
     * @description 使用测试爬虫爬取数据
     * @author gang.tu
     * @date 2019/11/25 15:10
     */
    List<WebsDto> queryByTestSpider(String query);

    /**
     * @description 将测试爬虫插入数据库，并且返回当前实例用于更新缓存
     * @author gang.tu
     * @date 2019/11/25 15:10
     */
    SpiderUrlBo insertTestUrl();
}