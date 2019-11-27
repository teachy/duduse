/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq.tables;


import com.tu.duduse.infrastructure.jooq.DefaultSchema;
import com.tu.duduse.infrastructure.jooq.Indexes;
import com.tu.duduse.infrastructure.jooq.Keys;
import com.tu.duduse.infrastructure.jooq.tables.records.SpiderUniqueRecord;

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
public class SpiderUnique extends TableImpl<SpiderUniqueRecord> {

    private static final long serialVersionUID = -1662073957;

    /**
     * The reference instance of <code>spider_unique</code>
     */
    public static final SpiderUnique SPIDER_UNIQUE = new SpiderUnique();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SpiderUniqueRecord> getRecordType() {
        return SpiderUniqueRecord.class;
    }

    /**
     * The column <code>spider_unique.id</code>.
     */
    public final TableField<SpiderUniqueRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>spider_unique.spider_id</code>.
     */
    public final TableField<SpiderUniqueRecord, String> SPIDER_ID = createField("spider_id", org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * Create a <code>spider_unique</code> table reference
     */
    public SpiderUnique() {
        this(DSL.name("spider_unique"), null);
    }

    /**
     * Create an aliased <code>spider_unique</code> table reference
     */
    public SpiderUnique(String alias) {
        this(DSL.name(alias), SPIDER_UNIQUE);
    }

    /**
     * Create an aliased <code>spider_unique</code> table reference
     */
    public SpiderUnique(Name alias) {
        this(alias, SPIDER_UNIQUE);
    }

    private SpiderUnique(Name alias, Table<SpiderUniqueRecord> aliased) {
        this(alias, aliased, null);
    }

    private SpiderUnique(Name alias, Table<SpiderUniqueRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SpiderUnique(Table<O> child, ForeignKey<O, SpiderUniqueRecord> key) {
        super(child, key, SPIDER_UNIQUE);
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
        return Arrays.<Index>asList(Indexes.SPIDER_UNIQUE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SpiderUniqueRecord> getPrimaryKey() {
        return Keys.KEY_SPIDER_UNIQUE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SpiderUniqueRecord>> getKeys() {
        return Arrays.<UniqueKey<SpiderUniqueRecord>>asList(Keys.KEY_SPIDER_UNIQUE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderUnique as(String alias) {
        return new SpiderUnique(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderUnique as(Name alias) {
        return new SpiderUnique(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SpiderUnique rename(String name) {
        return new SpiderUnique(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SpiderUnique rename(Name name) {
        return new SpiderUnique(name, null);
    }
}
