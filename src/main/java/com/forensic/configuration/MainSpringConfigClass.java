package com.forensic.configuration;

import com.forensic.dbmanager.datasource.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * This class contains general configuration for Spring framework, such as
 * classes for configuration {@link org.springframework.context.ApplicationContext} contexts,
 * classes for {@link org.springframework.context.annotation.Bean} configuration and so on
 */
@Configuration
//@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("property.properties")
@ComponentScan("com.forensic")
public class MainSpringConfigClass {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Bean
    public DataSource hikariDataSource(){
        return dataSourceConfig.configDataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
