package com.forensic.configuration;

import com.forensic.dbmanager.datasource.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.sql.DataSource;

/**
 * This class contains general configuration for Spring framework, such as
 * classes for configuration {@link org.springframework.context.ApplicationContext} contexts,
 * classes for {@link org.springframework.context.annotation.Bean} configuration and so on
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:prop.properties")
@ComponentScan("com.forensic")
@EnableWebMvc
public class MainSpringConfigClass implements WebMvcConfigurer {

    ApplicationContext applicationContext;

    DataSourceConfig dataSourceConfig;

    public MainSpringConfigClass(DataSourceConfig dataSourceConfig,
                                 ApplicationContext applicationContext) {
        this.dataSourceConfig = dataSourceConfig;
        this.applicationContext = applicationContext;
    }

    @Bean
    public DataSource hikariDataSource(){
        return dataSourceConfig.configDataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }


    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/jsp/");
        bean.setSuffix(".jsp");

        return bean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**")
                .addResourceLocations("/WEB-INF/view/img/");
//        registry.addResourceHandler("/js/**")
//                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/view/css/");

    }

}
