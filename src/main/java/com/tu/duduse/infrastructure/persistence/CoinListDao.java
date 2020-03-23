package com.tu.duduse.infrastructure.persistence;

import com.tu.duduse.common.model.bo.CoinListBo;
import com.tu.duduse.infrastructure.jooq.tables.records.CoinListRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoinListDao extends BaseDao {
    public void insert(CoinListBo coinListBo) {
        CoinListRecord coinListRecord = create.newRecord(COIN_LIST);
        BeanUtils.copyProperties(coinListBo, coinListRecord);
        coinListRecord.insert();
    }

    public CoinListBo queryOneById(String id) {
        return create.selectFrom(COIN_LIST).where(COIN_LIST.ID.eq(id)).fetchOneInto(CoinListBo.class);
    }

    public List<CoinListBo> queryList() {
        return create.select(COIN_LIST.ID, COIN_LIST.TYPE, COIN_LIST.ACTION,
                COIN_LIST.CREATE_TIME, COIN_LIST.NUM, COIN_LIST.NUM_DONE,
                COIN_LIST.PRICE, COIN_LIST.VOLUME, COIN_LIST.VOLUME_INIT,
                COIN_LIST.FEE, COIN_LIST.WIN, COIN_LIST.WIN_PERCENT,
                COIN_LIST.WIN_COUNT, COIN_LIST.WIN_COUNT_PERCENT, COIN_LIST.MARK)
                .from(COIN_LIST)
                .where(COIN_LIST.ID.gt("0"))
                .orderBy(COIN_LIST.ID.desc())
                .limit(30).fetchInto(CoinListBo.class);
    }
}