package com.tu.duduse.infrastructure.persistence;

import com.tu.duduse.common.model.dto.ToolsDto;
import com.tu.duduse.common.model.dto.WebsDto;
import com.tu.duduse.infrastructure.jooq.tables.records.ToolsRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gang.tu
 * @ClassName ToolsDao
 * @Description
 * @Date 2019/11/19 17:37
 */
@Repository
public class ToolsDao extends BaseDao {
    public List<ToolsDto> queryToolsDtos() {
        return create.selectFrom(TOOLS).where(TOOLS.STATUS.eq(STATUS)).fetchInto(ToolsDto.class);
    }

    public int insertTools(ToolsDto toolsDto) {
        ToolsRecord toolsRecord = create.newRecord(TOOLS);
        BeanUtils.copyProperties(toolsDto, toolsRecord);
        toolsRecord.setStatus(STATUS);
        return toolsRecord.insert();
    }

    public List<WebsDto> queryTools(String query) {
        return create.select(TOOLS.NAME.as("webName"), TOOLS.URL).from("`tools` where `status` ='1' and MATCH(`name`,`description`) AGAINST('\"" + query + "\"' IN BOOLEAN MODE)").fetchInto(WebsDto.class);
    }
}