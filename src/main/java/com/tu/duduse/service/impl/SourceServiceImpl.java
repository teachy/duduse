package com.tu.duduse.service.impl;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.dto.SourcesDto;
import com.tu.duduse.infrastructure.persistence.SourceDao;
import com.tu.duduse.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gang.tu
 * @ClassName SourceServiceImpl
 * @Description
 * @Date 2019/11/25 15:25
 */
@Service
public class SourceServiceImpl implements SourceService {
    private final SourceDao sourceDao;

    @Autowired
    SourceServiceImpl(SourceDao sourceDao) {
        this.sourceDao = sourceDao;
    }

    @Override
    public ResultData insertSource(SourcesDto sourcesDto) {
        return new ResultData(sourceDao.insertSource(sourcesDto));
    }
}