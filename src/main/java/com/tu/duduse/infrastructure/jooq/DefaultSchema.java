/*
 * This file is generated by jOOQ.
 */
package com.tu.duduse.infrastructure.jooq;


import com.tu.duduse.infrastructure.jooq.tables.IpList;
import com.tu.duduse.infrastructure.jooq.tables.Sources;
import com.tu.duduse.infrastructure.jooq.tables.SpiderBase;
import com.tu.duduse.infrastructure.jooq.tables.SpiderQueue;
import com.tu.duduse.infrastructure.jooq.tables.SpiderUnique;
import com.tu.duduse.infrastructure.jooq.tables.SpiderUrl;
import com.tu.duduse.infrastructure.jooq.tables.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = -1611728185;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>ip_list</code>.
     */
    public final IpList IP_LIST = com.tu.duduse.infrastructure.jooq.tables.IpList.IP_LIST;

    /**
     * The table <code>sources</code>.
     */
    public final Sources SOURCES = com.tu.duduse.infrastructure.jooq.tables.Sources.SOURCES;

    /**
     * 爬虫基本信息
     */
    public final SpiderBase SPIDER_BASE = com.tu.duduse.infrastructure.jooq.tables.SpiderBase.SPIDER_BASE;

    /**
     * 爬虫队列
     */
    public final SpiderQueue SPIDER_QUEUE = com.tu.duduse.infrastructure.jooq.tables.SpiderQueue.SPIDER_QUEUE;

    /**
     * The table <code>spider_unique</code>.
     */
    public final SpiderUnique SPIDER_UNIQUE = com.tu.duduse.infrastructure.jooq.tables.SpiderUnique.SPIDER_UNIQUE;

    /**
     * The table <code>spider_url</code>.
     */
    public final SpiderUrl SPIDER_URL = com.tu.duduse.infrastructure.jooq.tables.SpiderUrl.SPIDER_URL;

    /**
     * The table <code>tools</code>.
     */
    public final Tools TOOLS = com.tu.duduse.infrastructure.jooq.tables.Tools.TOOLS;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            IpList.IP_LIST,
            Sources.SOURCES,
            SpiderBase.SPIDER_BASE,
            SpiderQueue.SPIDER_QUEUE,
            SpiderUnique.SPIDER_UNIQUE,
            SpiderUrl.SPIDER_URL,
            Tools.TOOLS);
    }
}
