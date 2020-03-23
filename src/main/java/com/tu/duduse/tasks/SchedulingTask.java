package com.tu.duduse.tasks;

import com.tu.duduse.common.model.bo.CoinListBo;
import com.tu.duduse.infrastructure.persistence.CoinListDao;
import com.tu.duduse.infrastructure.persistence.SourceTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.tu.duduse.common.model.single.BaseData.getBaseData;

/**
 * @author gang.tu
 * @ClassName SchedulTask
 * @Description
 * @Date 2020/3/5 15:48
 */
@Component
public class SchedulingTask {
    @Autowired
    private SourceTypeDao sourceTypeDao;
    @Autowired
    private CoinListDao coinListDao;

    @Scheduled(cron = "*/15 * * * * ?")
    public void init() {
        getBaseData().setAllType(sourceTypeDao.getAllType());
        List<CoinListBo> listBos = coinListDao.queryList();
        listBos = listBos.stream().map(e -> {
            if (e.getAction().contains(BS)) {
                e.setWin(0);
                e.setWinPercent("--");
                e.setWinCount(0);
                e.setWinCountPercent("--");
            }
            return e;
        }).collect(Collectors.toList());
        getBaseData().setCoinList(listBos);
    }

    private static final String BS = "开";
}