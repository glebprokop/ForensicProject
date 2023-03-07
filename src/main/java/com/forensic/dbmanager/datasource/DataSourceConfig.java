package com.forensic.dbmanager.datasource;

import javax.sql.DataSource;

/**
 * Util interface to create the configuration of {@link DataSource} class. More useful
 * create data source using the connection pool. Under Spring framework all subclasses
 * are configured using properties from property file.
 * <P>
 * Examples of implementation: <P>
 * {@link DataSourceHikariConfig} - data source config using the Hikari connection pool
 *
 */
public interface DataSourceConfig {

    /**
     * Method returned the configured {@link DataSource} instance, ready for use.
     * Data source used for getting connections, access to databases of files and getting result
     *
     * @return {@link DataSource} configured instance
     */
    DataSource configDataSource();
}
