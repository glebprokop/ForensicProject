/**
 * This package contains all util classes for database access. Under Spring framework classes are configured
 * using properties from property file.
 * <P>
 * This package include submodules, heading by the next interfaces:<P>
 * - {@link com.forensic.dbmanager.datasource.DataSourceConfig} interface describe how to configure the {@link javax.sql.DataSource} (for example,
 * how to configure the data source, using the Hikari connection pool, like in {@link com.forensic.dbmanager.datasource.DataSourceHikariConfig}
 * <P>
 * - {@link com.forensic.dbmanager.parser.ClassParser} interface used for the parsing of the {@link java.sql.ResultSet}, getting from the Statements after
 * connection to data source. The implementation of interface used to convert ResultSet to entities in application, similar to RowMapper interface in general
 * <P>
 * - UNREALIZABLE - {@link com.forensic.dbmanager.manager.DataBaseManager} interface will be get union access to data source according the user`s
 * request in SQL, actually as the JDBC Template
 */
package com.forensic.dbmanager;