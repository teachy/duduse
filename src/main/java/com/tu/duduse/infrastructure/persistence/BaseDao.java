package com.tu.duduse.infrastructure.persistence;

import com.tu.duduse.common.listener.JooqLogListener;
import com.tu.duduse.infrastructure.jooq.Tables;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public abstract class BaseDao extends Tables {
    protected static final String STATUS="1";
    private DataSource dataSource;
    DSLContext create;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void init() throws SQLException {
        Configuration configuration = new DefaultConfiguration().set(dataSource).set(getType());
        configuration.set(new JooqLogListener());
        create = DSL.using(configuration);
    }

    private SQLDialect getType() throws SQLException {
        SQLDialect sqlType = SQLDialect.MYSQL;
        try (Connection conn = dataSource.getConnection()) {
            String type = conn.getMetaData().getDriverName();
            if (type.startsWith("H2")) {
                sqlType = SQLDialect.H2;
            }
        }
        return sqlType;
    }
}
