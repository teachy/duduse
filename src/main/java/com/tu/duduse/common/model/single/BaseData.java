package com.tu.duduse.common.model.single;

import com.tu.duduse.common.model.bo.CoinListBo;
import com.tu.duduse.common.model.dto.SourceTypeDto;

import java.util.List;

/**
 * @author gang.tu
 * @ClassName BaseData
 * @Description
 * @Date 2020/3/5 15:57
 */
public class BaseData {
    private static final BaseData baseData = new BaseData();
    private List<SourceTypeDto> allType;
    private List<CoinListBo> coinList;

    public static BaseData getBaseData() {
        return baseData;
    }

    public List<SourceTypeDto> getAllType() {
        return allType;
    }

    public void setAllType(List<SourceTypeDto> allType) {
        this.allType = allType;
    }

    public List<CoinListBo> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<CoinListBo> coinList) {
        this.coinList = coinList;
    }

    private BaseData() {

    }
}