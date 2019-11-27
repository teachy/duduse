package com.tu.duduse.infrastructure.persistence;

import com.tu.duduse.common.model.bo.IpListBo;
import com.tu.duduse.infrastructure.jooq.tables.records.IpListRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

/**
 * @author gang.tu
 * @description TODO
 * @date 2019/11/25 11:20
 */
@Repository
public class IpListDao extends BaseDao {

    public void insert(IpListBo ipListBo) {
        IpListRecord ipListRecord = create.newRecord(IP_LIST);
        BeanUtils.copyProperties(ipListBo, ipListRecord);
        ipListRecord.setUseTime((int) ipListBo.getUseTime());
        ipListRecord.insert();
    }
}