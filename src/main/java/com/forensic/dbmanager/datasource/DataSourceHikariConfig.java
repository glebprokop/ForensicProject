package com.forensic.dbmanager.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Implementation of {@link DataSourceConfig} interface, using {@link HikariDataSource} configuration with
 * connection pool. Get configurable {@link DataSource} instance, based on properties from property source
 */
@Component
public class DataSourceHikariConfig implements DataSourceConfig{

    @Value("${db.postgres.driver}")
    private String driver;

    @Value("${db.postgres.login}")
    private String login;

    @Value("${db.postgres.password}")
    private String password;

    @Value("${db.postgres.jdbcurl}")
    private String JDBCurl;

    @Value("${db.postgres.poolsize}")
    private Integer poolsize;

    @Override
    public DataSource configDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setUsername(login);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driver);
        hikariDataSource.setMaximumPoolSize(poolsize);
        hikariDataSource.setJdbcUrl(JDBCurl);

        return hikariDataSource;
    }
}
