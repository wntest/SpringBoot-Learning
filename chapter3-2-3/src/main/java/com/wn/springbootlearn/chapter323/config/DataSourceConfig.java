package com.wn.springbootlearn.chapter323.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "wwnDataSource")
    @Qualifier("wwnDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.wwn")
    public DataSource wwnDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "wnDataSource")
    @Qualifier("wnDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.wn")
    public DataSource wnDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "wwnJdbcTemplate")
    @Autowired
    public JdbcTemplate wwnTemplate(@Qualifier("wwnDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "wnJdbcTemplate")
    public JdbcTemplate wnTemplate(@Qualifier("wnDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
