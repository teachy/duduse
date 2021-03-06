/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables.records;


import com.tu.duduse.infrastructure.jooq.tables.IpList;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class IpListRecord extends UpdatableRecordImpl<IpListRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = 1909043100;

    /**
     * Setter for <code>ip_list.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ip_list.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ip_list.ip</code>. 访问ip
     */
    public void setIp(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ip_list.ip</code>. 访问ip
     */
    public String getIp() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ip_list.query</code>. query关键词
     */
    public void setQuery(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>ip_list.query</code>. query关键词
     */
    public String getQuery() {
        return (String) get(2);
    }

    /**
     * Setter for <code>ip_list.use_time</code>. 耗时
     */
    public void setUseTime(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>ip_list.use_time</code>. 耗时
     */
    public Integer getUseTime() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return IpList.IP_LIST.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return IpList.IP_LIST.IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return IpList.IP_LIST.QUERY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return IpList.IP_LIST.USE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getQuery();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getUseTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getQuery();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getUseTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpListRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpListRecord value2(String value) {
        setIp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpListRecord value3(String value) {
        setQuery(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpListRecord value4(Integer value) {
        setUseTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpListRecord values(Integer value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IpListRecord
     */
    public IpListRecord() {
        super(IpList.IP_LIST);
    }

    /**
     * Create a detached, initialised IpListRecord
     */
    public IpListRecord(Integer id, String ip, String query, Integer useTime) {
        super(IpList.IP_LIST);

        set(0, id);
        set(1, ip);
        set(2, query);
        set(3, useTime);
    }
}
