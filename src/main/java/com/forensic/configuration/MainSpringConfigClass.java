package com.forensic.configuration;

import com.forensic.dbmanager.datasource.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("property.properties")
@ComponentScan("com.forensic")
public class MainSpringConfigClass {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Bean
    public DataSource hikariDataSource(){
        return dataSourceConfig.configDataSource();
    }
}
