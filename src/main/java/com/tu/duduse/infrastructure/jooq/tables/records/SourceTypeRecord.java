/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables.records;


import com.tu.duduse.infrastructure.jooq.tables.SourceType;

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
public class SourceTypeRecord extends UpdatableRecordImpl<SourceTypeRecord> implements Record6<Integer, String, String, String, String, String> {

    private static final long serialVersionUID = -840796136;

    /**
     * Setter for <code>source_type.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>source_type.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>source_type.type</code>. 类型
     */
    public void setType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>source_type.type</code>. 类型
     */
    public String getType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>source_type.type_value</code>. 类型值
     */
    public void setTypeValue(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>source_type.type_value</code>. 类型值
     */
    public String getTypeValue() {
        return (String) get(2);
    }

    /**
     * Setter for <code>source_type.status</code>. 是否可以使用（1：可用，0不可用）
     */
    public void setStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>source_type.status</code>. 是否可以使用（1：可用，0不可用）
     */
    public String getStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>source_type.describe</code>. 描述
     */
    public void setDescribe(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>source_type.describe</code>. 描述
     */
    public String getDescribe() {
        return (String) get(4);
    }

    /**
     * Setter for <code>source_type.sort</code>. 序号
     */
    public void setSort(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>source_type.sort</code>. 序号
     */
    public String getSort() {
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
        return SourceType.SOURCE_TYPE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SourceType.SOURCE_TYPE.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SourceType.SOURCE_TYPE.TYPE_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SourceType.SOURCE_TYPE.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SourceType.SOURCE_TYPE.DESCRIBE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return SourceType.SOURCE_TYPE.SORT;
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
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getTypeValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getDescribe();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getSort();
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
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTypeValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDescribe();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceTypeRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceTypeRecord value2(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceTypeRecord value3(String value) {
        setTypeValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceTypeRecord value4(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceTypeRecord value5(String value) {
        setDescribe(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceTypeRecord value6(String value) {
        setSort(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceTypeRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6) {
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
     * Create a detached SourceTypeRecord
     */
    public SourceTypeRecord() {
        super(SourceType.SOURCE_TYPE);
    }

    /**
     * Create a detached, initialised SourceTypeRecord
     */
    public SourceTypeRecord(Integer id, String type, String typeValue, String status, String describe, String sort) {
        super(SourceType.SOURCE_TYPE);

        set(0, id);
        set(1, type);
        set(2, typeValue);
        set(3, status);
        set(4, describe);
        set(5, sort);
    }
}
