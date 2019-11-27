/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables.records;


import com.tu.duduse.infrastructure.jooq.tables.Sources;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class SourcesRecord extends UpdatableRecordImpl<SourcesRecord> implements Record6<Integer, String, String, String, String, String> {

    private static final long serialVersionUID = -1437265667;

    /**
     * Setter for <code>sources.id</code>. 唯一标识
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>sources.id</code>. 唯一标识
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sources.name</code>. 资源描述
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sources.name</code>. 资源描述
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sources.url</code>. 资源url
     */
    public void setUrl(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sources.url</code>. 资源url
     */
    public String getUrl() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sources.pass</code>. 资源密码
     */
    public void setPass(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>sources.pass</code>. 资源密码
     */
    public String getPass() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sources.status</code>. 资源是否可用（0：可用1：可用但是有错误2：不可用）
     */
    public void setStatus(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>sources.status</code>. 资源是否可用（0：可用1：可用但是有错误2：不可用）
     */
    public String getStatus() {
        return (String) get(4);
    }

    /**
     * Setter for <code>sources.description</code>. 资源描述
     */
    public void setDescription(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>sources.description</code>. 资源描述
     */
    public String getDescription() {
        return (String) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Sources.SOURCES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Sources.SOURCES.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Sources.SOURCES.URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Sources.SOURCES.PASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Sources.SOURCES.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Sources.SOURCES.DESCRIPTION;
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getDescription();
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourcesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourcesRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourcesRecord value3(String value) {
        setUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourcesRecord value4(String value) {
        setPass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourcesRecord value5(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourcesRecord value6(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourcesRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SourcesRecord
     */
    public SourcesRecord() {
        super(Sources.SOURCES);
    }

    /**
     * Create a detached, initialised SourcesRecord
     */
    public SourcesRecord(Integer id, String name, String url, String pass, String status, String description) {
        super(Sources.SOURCES);

        set(0, id);
        set(1, name);
        set(2, url);
        set(3, pass);
        set(4, status);
        set(5, description);
    }
}