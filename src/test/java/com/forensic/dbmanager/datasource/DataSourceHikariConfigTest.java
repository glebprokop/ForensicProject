package com.forensic.dbmanager.datasource;

import com.forensic.configuration.MainSpringConfigClass;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DataSourceHikariConfigTest{

    GenericApplicationContext context;

    DataSourceConfig config;

    DataSource dataSource;

    @Before
    public void info(){
        context = new AnnotationConfigApplicationContext(MainSpringConfigClass.class);

        config = context.getBean("dataSourceHikariConfig", DataSourceConfig.class);
    }

    @Test
    public void testConfigGeneration(){
        config = context.getBean("dataSourceHikariConfig", DataSourceConfig.class);

        assertNotNull(config);
    }

    @Test
    public void testDataSourceGetting(){
        dataSource = config.configDataSource();

        assertNotNull(dataSource);
    }

    @Test
    public void testConfigDataSourceConnection() {
        dataSource = config.configDataSource();

        try {
            assertNotNull(dataSource.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}