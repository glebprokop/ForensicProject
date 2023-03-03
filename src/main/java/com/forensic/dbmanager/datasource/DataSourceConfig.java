package com.forensic.dbmanager.datasource;

import javax.sql.DataSource;

/**
 * Interface to create the configuration of {@link DataSource} class. More useful create data source
 * using the connection pool
 *
 * @see DataSourceHikariConfig DataSourceHikariConfig
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
