package com.tu.duduse.service;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.bo.SpiderUrlBo;

/**
 * @author gang.tu
 * @ClassName SpiderUrlService
 * @Description
 * @Date 2019/11/14 15:50
 */

public interface SpiderUrlService {
    ResultData insertSpiderUrl(SpiderUrlBo spiderUrlBo);

    ResultData insertTestSpiderUrl(SpiderUrlBo spiderUrlBo);

    SpiderUrlBo insertTestUrl();
}
