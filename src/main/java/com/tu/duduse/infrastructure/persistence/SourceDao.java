package com.tu.duduse.infrastructure.persistence;

import com.tu.duduse.common.model.dto.SourcesDto;
import com.tu.duduse.common.model.dto.ToolsDto;
import com.tu.duduse.infrastructure.jooq.tables.records.SourcesRecord;
import com.tu.duduse.infrastructure.jooq.tables.records.ToolsRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gang.tu
 * @ClassName DictionaryDao
 * @Description
 * @Date 2019/10/10 16:16
 */
@Repository
public class SourceDao extends BaseDao {

    public List<SourcesDto> querySources(String query) {
        return create.selectFrom("`sources` where MATCH(name) AGAINST('\"" + query + "\"' IN BOOLEAN MODE)").fetchInto(SourcesDto.class);
    }

    public int insertSource(SourcesDto sourcesDto) {
        SourcesRecord sourcesRecord = create.newRecord(SOURCES);
        BeanUtils.copyProperties(sourcesDto, sourcesRecord);
        sourcesRecord.setStatus(STATUS);
        return sourcesRecord.insert();
    }
}