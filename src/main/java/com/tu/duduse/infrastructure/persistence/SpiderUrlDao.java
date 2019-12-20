package com.tu.duduse.infrastructure.persistence;

import com.tu.duduse.common.model.bo.SpiderUrlBo;
import com.tu.duduse.infrastructure.jooq.tables.records.SpiderUrlRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gang.tu
 * @ClassName SpiderUrlDao
 * @Description
 * @Date 2019/11/14 15:36
 */
@Repository
public class SpiderUrlDao extends BaseDao {

    public int insertSpiderUrl(SpiderUrlBo spiderUrlBo) {
        SpiderUrlRecord spiderUrlRecord = create.newRecord(SPIDER_URL);
        BeanUtils.copyProperties(spiderUrlBo, spiderUrlRecord);
        return spiderUrlRecord.insert();
    }

    public List<SpiderUrlBo> getAllSpider() {
        return create.selectFrom(SPIDER_URL).where(SPIDER_URL.STATUS.eq(STATUS)).fetchInto(SpiderUrlBo.class);
    }

    public SpiderUrlBo getSpiderByName(String name) {
        return create.selectFrom(SPIDER_URL).where(SPIDER_URL.NAME.eq(name).and(SPIDER_URL.STATUS.eq(STATUS))).fetchOneInto(SpiderUrlBo.class);
    }

    public void updateErrorSpiderByName(String name) {
        SpiderUrlBo spiderUrlBo = getSpiderByName(name);
        create.update(SPIDER_URL).set(SPIDER_URL.ERROR_NUM, spiderUrlBo.getErrorNum() + 1).where(SPIDER_URL.NAME.eq(name)).execute();
    }
}