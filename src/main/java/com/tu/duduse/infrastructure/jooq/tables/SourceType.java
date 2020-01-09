/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables;


import com.tu.duduse.infrastructure.jooq.DefaultSchema;
import com.tu.duduse.infrastructure.jooq.Indexes;
import com.tu.duduse.infrastructure.jooq.Keys;
import com.tu.duduse.infrastructure.jooq.tables.records.SourceTypeRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class SourceType extends TableImpl<SourceTypeRecord> {

    private static final long serialVersionUID = -474304000;

    /**
     * The reference instance of <code>source_type</code>
     */
    public static final SourceType SOURCE_TYPE = new SourceType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SourceTypeRecord> getRecordType() {
        return SourceTypeRecord.class;
    }

    /**
     * The column <code>source_type.id</code>.
     */
    public final TableField<SourceTypeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>source_type.type</code>. 类型
     */
    public final TableField<SourceTypeRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(8).nullable(false), this, "类型");

    /**
     * The column <code>source_type.type_value</code>. 类型值
     */
    public final TableField<SourceTypeRecord, String> TYPE_VALUE = createField("type_value", org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "类型值");

    /**
     * The column <code>source_type.status</code>. 是否可以使用（1：可用，0不可用）
     */
    public final TableField<SourceTypeRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR(8).nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.VARCHAR)), this, "是否可以使用（1：可用，0不可用）");

    /**
     * The column <code>source_type.describe</code>. 描述
     */
    public final TableField<SourceTypeRecord, String> DESCRIBE = createField("describe", org.jooq.impl.SQLDataType.VARCHAR(128), this, "描述");

    /**
     * The column <code>source_type.sort</code>. 序号
     */
    public final TableField<SourceTypeRecord, String> SORT = createField("sort", org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "序号");

    /**
     * Create a <code>source_type</code> table reference
     */
    public SourceType() {
        this(DSL.name("source_type"), null);
    }

    /**
     * Create an aliased <code>source_type</code> table reference
     */
    public SourceType(String alias) {
        this(DSL.name(alias), SOURCE_TYPE);
    }

    /**
     * Create an aliased <code>source_type</code> table reference
     */
    public SourceType(Name alias) {
        this(alias, SOURCE_TYPE);
    }

    private SourceType(Name alias, Table<SourceTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private SourceType(Name alias, Table<SourceTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SourceType(Table<O> child, ForeignKey<O, SourceTypeRecord> key) {
        super(child, key, SOURCE_TYPE);
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
        return Arrays.<Index>asList(Indexes.SOURCE_TYPE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SourceTypeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SOURCE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SourceTypeRecord> getPrimaryKey() {
        return Keys.KEY_SOURCE_TYPE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SourceTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<SourceTypeRecord>>asList(Keys.KEY_SOURCE_TYPE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceType as(String alias) {
        return new SourceType(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceType as(Name alias) {
        return new SourceType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SourceType rename(String name) {
        return new SourceType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SourceType rename(Name name) {
        return new SourceType(name, null);
    }
}