/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables;


import com.tu.duduse.infrastructure.jooq.DefaultSchema;
import com.tu.duduse.infrastructure.jooq.Indexes;
import com.tu.duduse.infrastructure.jooq.Keys;
import com.tu.duduse.infrastructure.jooq.tables.records.CoinListRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class CoinList extends TableImpl<CoinListRecord> {

    private static final long serialVersionUID = -1286648614;

    /**
     * The reference instance of <code>coin_list</code>
     */
    public static final CoinList COIN_LIST = new CoinList();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CoinListRecord> getRecordType() {
        return CoinListRecord.class;
    }

    /**
     * The column <code>coin_list.id</code>.
     */
    public final TableField<CoinListRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>coin_list.id_trade</code>. 合约号
     */
    public final TableField<CoinListRecord, String> ID_TRADE = createField("id_trade", org.jooq.impl.SQLDataType.VARCHAR(64), this, "合约号");

    /**
     * The column <code>coin_list.type</code>.
     */
    public final TableField<CoinListRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>coin_list.action</code>. 行为：比如开仓，买，卖
     */
    public final TableField<CoinListRecord, String> ACTION = createField("action", org.jooq.impl.SQLDataType.VARCHAR(16), this, "行为：比如开仓，买，卖");

    /**
     * The column <code>coin_list.create_time</code>. 发生时间
     */
    public final TableField<CoinListRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "发生时间");

    /**
     * The column <code>coin_list.num</code>. 操作合约数量
     */
    public final TableField<CoinListRecord, String> NUM = createField("num", org.jooq.impl.SQLDataType.VARCHAR(16), this, "操作合约数量");

    /**
     * The column <code>coin_list.num_done</code>. 成交数量
     */
    public final TableField<CoinListRecord, String> NUM_DONE = createField("num_done", org.jooq.impl.SQLDataType.VARCHAR(16), this, "成交数量");

    /**
     * The column <code>coin_list.price</code>. 价格
     */
    public final TableField<CoinListRecord, Double> PRICE = createField("price", org.jooq.impl.SQLDataType.DOUBLE, this, "价格");

    /**
     * The column <code>coin_list.volume</code>. 当前拥有btc
     */
    public final TableField<CoinListRecord, Double> VOLUME = createField("volume", org.jooq.impl.SQLDataType.DOUBLE, this, "当前拥有btc");

    /**
     * The column <code>coin_list.volume_init</code>. 初始btc
     */
    public final TableField<CoinListRecord, Double> VOLUME_INIT = createField("volume_init", org.jooq.impl.SQLDataType.DOUBLE, this, "初始btc");

    /**
     * The column <code>coin_list.fee</code>. 手续费
     */
    public final TableField<CoinListRecord, Double> FEE = createField("fee", org.jooq.impl.SQLDataType.DOUBLE, this, "手续费");

    /**
     * The column <code>coin_list.win</code>. 当前盈利
     */
    public final TableField<CoinListRecord, Double> WIN = createField("win", org.jooq.impl.SQLDataType.DOUBLE, this, "当前盈利");

    /**
     * The column <code>coin_list.win_percent</code>. 盈利百分比
     */
    public final TableField<CoinListRecord, String> WIN_PERCENT = createField("win_percent", org.jooq.impl.SQLDataType.VARCHAR(16), this, "盈利百分比");

    /**
     * The column <code>coin_list.win_count</code>. 总共盈利
     */
    public final TableField<CoinListRecord, Double> WIN_COUNT = createField("win_count", org.jooq.impl.SQLDataType.DOUBLE, this, "总共盈利");

    /**
     * The column <code>coin_list.win_count_percent</code>. 总共盈利百分比
     */
    public final TableField<CoinListRecord, String> WIN_COUNT_PERCENT = createField("win_count_percent", org.jooq.impl.SQLDataType.VARCHAR(16), this, "总共盈利百分比");

    /**
     * The column <code>coin_list.mark</code>. 备注
     */
    public final TableField<CoinListRecord, String> MARK = createField("mark", org.jooq.impl.SQLDataType.VARCHAR(128), this, "备注");

    /**
     * Create a <code>coin_list</code> table reference
     */
    public CoinList() {
        this(DSL.name("coin_list"), null);
    }

    /**
     * Create an aliased <code>coin_list</code> table reference
     */
    public CoinList(String alias) {
        this(DSL.name(alias), COIN_LIST);
    }

    /**
     * Create an aliased <code>coin_list</code> table reference
     */
    public CoinList(Name alias) {
        this(alias, COIN_LIST);
    }

    private CoinList(Name alias, Table<CoinListRecord> aliased) {
        this(alias, aliased, null);
    }

    private CoinList(Name alias, Table<CoinListRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> CoinList(Table<O> child, ForeignKey<O, CoinListRecord> key) {
        super(child, key, COIN_LIST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.COIN_LIST_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CoinListRecord> getPrimaryKey() {
        return Keys.KEY_COIN_LIST_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CoinListRecord>> getKeys() {
        return Arrays.<UniqueKey<CoinListRecord>>asList(Keys.KEY_COIN_LIST_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinList as(String alias) {
        return new CoinList(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CoinList as(Name alias) {
        return new CoinList(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CoinList rename(String name) {
        return new CoinList(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CoinList rename(Name name) {
        return new CoinList(name, null);
    }
}
