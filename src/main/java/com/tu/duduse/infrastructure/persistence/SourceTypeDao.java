package com.tu.duduse.infrastructure.persistence;

import com.tu.duduse.common.model.dto.SourceTypeDto;
import com.tu.duduse.common.model.dto.SourcesDto;
import com.tu.duduse.infrastructure.jooq.tables.records.SourcesRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SourceTypeDao extends BaseDao {

    public List<SourceTypeDto> getAllType() {
        return create.selectFrom(SOURCE_TYPE).where(SOURCE_TYPE.STATUS.eq(STATUS)).orderBy(SOURCE_TYPE.SORT).fetchInto(SourceTypeDto.class);
    }

}