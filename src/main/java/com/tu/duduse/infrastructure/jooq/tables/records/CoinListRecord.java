/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables.records;


import com.tu.duduse.infrastructure.jooq.tables.CoinList;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CoinListRecord extends UpdatableRecordImpl<CoinListRecord> implements Record16<String, String, String, String, Timestamp, String, String, Double, Double, Double, Double, Double, String, Double, String, String> {

    private static final long serialVersionUID = 1266311067;

    /**
     * Setter for <code>coin_list.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>coin_list.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>coin_list.id_trade</code>. 合约号
     */
    public void setIdTrade(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>coin_list.id_trade</code>. 合约号
     */
    public String getIdTrade() {
        return (String) get(1);
    }

    /**
     * Setter for <code>coin_list.type</code>.
     */
    public void setType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>coin_list.type</code>.
     */
    public String getType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>coin_list.action</code>. 行为：比如开仓，买，卖
     */
    public void setAction(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>coin_list.action</code>. 行为：比如开仓，买，卖
     */
    public String getAction() {
        return (String) get(3);
    }

    /**
     * Setter for <code>coin_list.create_time</code>. 发生时间
     */
    public void setCreateTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>coin_list.create_time</code>. 发生时间
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>coin_list.num</code>. 操作合约数量
     */
    public void setNum(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>coin_list.num</code>. 操作合约数量
     */
    public String getNum() {
        return (String) get(5);
    }

    /**
     * Setter for <code>coin_list.num_done</code>. 成交数量
     */
    public void setNumDone(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>coin_list.num_done</code>. 成交数量
     */
    public String getNumDone() {
        return (String) get(6);
    }

    /**
     * Setter for <code>coin_list.price</code>. 价格
     */
    public void setPrice(Double value) {
        set(7, value);
    }

    /**
     * Getter for <code>coin_list.price</code>. 价格
     */
    public Double getPrice() {
        return (Double) get(7);
    }

    /**
     * Setter for <code>coin_list.volume</code>. 当前拥有btc
     */
    public void setVolume(Double value) {
        set(8, value);
    }

    /**
     * Getter for <code>coin_list.volume</code>. 当前拥有btc
     */
    public Double getVolume() {
        return (Double) get(8);
    }

    /**
     * Setter for <code>coin_list.volume_init</code>. 初始btc
     */
    public void setVolumeInit(Double value) {
        set(9, value);
    }

    /**
     * Getter for <code>coin_list.volume_init</code>. 初始btc
     */
    public Double getVolumeInit() {
        return (Double) get(9);
    }

    /**
     * Setter for <code>coin_list.fee</code>. 手续费
     */
    public void setFee(Double value) {
        set(10, value);
    }

    /**
     * Getter for <code>coin_list.fee</code>. 手续费
     */
    public Double getFee() {
        return (Double) get(10);
    }

    /**
     * Setter for <code>coin_list.win</code>. 当前盈利
     */
    public void setWin(Double value) {
        set(11, value);
    }

    /**
     * Getter for <code>coin_list.win</code>. 当前盈利
     */
    public Double getWin() {
        return (Double) get(11);
    }

    /**
     * Setter for <code>coin_list.win_percent</code>. 盈利百分比
     */
    public void setWinPercent(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>coin_list.win_percent</code>. 盈利百分比
     */
    public String getWinPercent() {
        return (String) get(12);
    }

    /**
     * Setter for <code>coin_list.win_count</code>. 总共盈利
     */
    public void setWinCount(Double value) {
        set(13, value);
    }

    /**
     * Getter for <code>coin_list.win_count</code>. 总共盈利
     */
    public Double getWinCount() {
        return (Double) get(13);
    }

    /**
     * Setter for <code>coin_list.win_count_percent</code>. 总共盈利百分比
     */
    public void setWinCountPercent(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>coin_list.win_count_percent</code>. 总共盈利百分比
     */
    public String getWinCountPercent() {
        return (String) get(14);
    }

    /**
     * Setter for <code>coin_list.mark</code>. 备注
     */
    public void setMark(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>coin_list.mark</code>. 备注
     */
    public String getMark() {
        return (String) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<String, String, String, String, Timestamp, String, String, Double, Double, Double, Double, Double, String, Double, String, String> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<String, String, String, String, Timestamp, String, String, Double, Double, Double, Double, Double, String, Double, String, String> valuesRow() {
        return (Row16) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return CoinList.COIN_LIST.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return CoinList.COIN_LIST.ID_TRADE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return CoinList.COIN_LIST.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return CoinList.COIN_LIST.ACTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return CoinList.COIN_LIST.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return CoinList.COIN_LIST.NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return CoinList.COIN_LIST.NUM_DONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field8() {
        return CoinList.COIN_LIST.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field9() {
        return CoinList.COIN_LIST.VOLUME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field10() {
        return CoinList.COIN_LIST.VOLUME_INIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field11() {
        return CoinList.COIN_LIST.FEE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field12() {
        return CoinList.COIN_LIST.WIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return CoinList.COIN_LIST.WIN_PERCENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field14() {
        return CoinList.COIN_LIST.WIN_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return CoinList.COIN_LIST.WIN_COUNT_PERCENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return CoinList.COIN_LIST.MARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getIdTrade();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getAction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getNumDone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component8() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component9() {
        return getVolume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component10() {
        return getVolumeInit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component11() {
        return getFee();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component12() {
        return getWin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getWinPercent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component14() {
        return getWinCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getWinCountPercent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component16() {
        return getMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getIdTrade();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getNumDone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value8() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value9() {
        return getVolume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value10() {
        return getVolumeInit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value11() {
        return getFee();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value12() {
        return getWin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getWinPercent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value14() {
        return getWinCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getWinCountPercent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value2(String value) {
        setIdTrade(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value3(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value4(String value) {
        setAction(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value5(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value6(String value) {
        setNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value7(String value) {
        setNumDone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value8(Double value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value9(Double value) {
        setVolume(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value10(Double value) {
        setVolumeInit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value11(Double value) {
        setFee(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value12(Double value) {
        setWin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value13(String value) {
        setWinPercent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value14(Double value) {
        setWinCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value15(String value) {
        setWinCountPercent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord value16(String value) {
        setMark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinListRecord values(String value1, String value2, String value3, String value4, Timestamp value5, String value6, String value7, Double value8, Double value9, Double value10, Double value11, Double value12, String value13, Double value14, String value15, String value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CoinListRecord
     */
    public CoinListRecord() {
        super(CoinList.COIN_LIST);
    }

    /**
     * Create a detached, initialised CoinListRecord
     */
    public CoinListRecord(String id, String idTrade, String type, String action, Timestamp createTime, String num, String numDone, Double price, Double volume, Double volumeInit, Double fee, Double win, String winPercent, Double winCount, String winCountPercent, String mark) {
        super(CoinList.COIN_LIST);

        set(0, id);
        set(1, idTrade);
        set(2, type);
        set(3, action);
        set(4, createTime);
        set(5, num);
        set(6, numDone);
        set(7, price);
        set(8, volume);
        set(9, volumeInit);
        set(10, fee);
        set(11, win);
        set(12, winPercent);
        set(13, winCount);
        set(14, winCountPercent);
        set(15, mark);
    }
}
