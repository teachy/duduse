package com.tu.duduse.service.impl;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.bo.SpiderUrlBo;
import com.tu.duduse.infrastructure.persistence.SpiderUrlDao;
import com.tu.duduse.service.SpiderUrlService;
import com.tu.duduse.spider.SpiderWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gang.tu
 * @ClassName SpiderUrlServiceImpl
 * @Description
 * @Date 2019/11/14 15:54
 */
@Service
public class SpiderUrlServiceImpl implements SpiderUrlService {

    private final SpiderUrlDao spiderUrlDao;

    private final SpiderWorkService spiderWorkService;

    @Autowired
    SpiderUrlServiceImpl(SpiderUrlDao spiderUrlDao, SpiderWorkService spiderWorkService) {
        this.spiderUrlDao = spiderUrlDao;
        this.spiderWorkService = spiderWorkService;
    }

    @Override
    public ResultData insertSpiderUrl(SpiderUrlBo spiderUrlBo) {
        if (spiderUrlDao.insertSpiderUrl(spiderUrlBo) > 0) {
            return new ResultData();
        }
        return new ResultData(ResultData.ERROR, "新增数据失败！");
    }

    @Override
    public ResultData insertTestSpiderUrl(SpiderUrlBo spiderUrlBo) {
        if (spiderWorkService.insertTestSpiderUrl(spiderUrlBo)) {
            return new ResultData();
        }
        return new ResultData(ResultData.ERROR, "已经存在数据！");
    }

    @Override
    public SpiderUrlBo insertTestUrl() {
        return spiderWorkService.insertTestUrl();
    }
}