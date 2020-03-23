/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables.records;


import com.tu.duduse.infrastructure.jooq.tables.Hosts;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class HostsRecord extends UpdatableRecordImpl<HostsRecord> implements Record5<Integer, String, String, String, String> {

    private static final long serialVersionUID = 375324275;

    /**
     * Setter for <code>hosts.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>hosts.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>hosts.ip</code>.
     */
    public void setIp(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>hosts.ip</code>.
     */
    public String getIp() {
        return (String) get(1);
    }

    /**
     * Setter for <code>hosts.user</code>.
     */
    public void setUser(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>hosts.user</code>.
     */
    public String getUser() {
        return (String) get(2);
    }

    /**
     * Setter for <code>hosts.password_mysql</code>.
     */
    public void setPasswordMysql(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>hosts.password_mysql</code>.
     */
    public String getPasswordMysql() {
        return (String) get(3);
    }

    /**
     * Setter for <code>hosts.password_host</code>.
     */
    public void setPasswordHost(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>hosts.password_host</code>.
     */
    public String getPasswordHost() {
        return (String) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Hosts.HOSTS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Hosts.HOSTS.IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Hosts.HOSTS.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Hosts.HOSTS.PASSWORD_MYSQL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Hosts.HOSTS.PASSWORD_HOST;
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
        return getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPasswordMysql();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getPasswordHost();
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
        return getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPasswordMysql();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPasswordHost();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostsRecord value2(String value) {
        setIp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostsRecord value3(String value) {
        setUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostsRecord value4(String value) {
        setPasswordMysql(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostsRecord value5(String value) {
        setPasswordHost(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostsRecord values(Integer value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached HostsRecord
     */
    public HostsRecord() {
        super(Hosts.HOSTS);
    }

    /**
     * Create a detached, initialised HostsRecord
     */
    public HostsRecord(Integer id, String ip, String user, String passwordMysql, String passwordHost) {
        super(Hosts.HOSTS);

        set(0, id);
        set(1, ip);
        set(2, user);
        set(3, passwordMysql);
        set(4, passwordHost);
    }
}
