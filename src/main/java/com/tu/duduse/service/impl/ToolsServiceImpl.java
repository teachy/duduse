package com.tu.duduse.service.impl;

import com.tu.duduse.common.model.ResultData;
import com.tu.duduse.common.model.dto.ToolsDto;
import com.tu.duduse.infrastructure.persistence.ToolsDao;
import com.tu.duduse.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gang.tu
 * @ClassName ToolsServiceImpl
 * @Description
 * @Date 2019/11/19 17:36
 */
@Service
public class ToolsServiceImpl implements ToolsService {

    final ToolsDao toolsDao;

    @Autowired
    ToolsServiceImpl(ToolsDao toolsDao) {
        this.toolsDao = toolsDao;
    }

    @Override
    public List<ToolsDto> queryToolsDtos() {
        return toolsDao.queryToolsDtos();
    }

    @Override
    public ResultData insertTools(ToolsDto toolsDto) {
        return new ResultData(toolsDao.insertTools(toolsDto));
    }
}