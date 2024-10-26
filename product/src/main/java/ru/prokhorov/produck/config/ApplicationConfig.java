package ru.prokhorov.produck.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Конфигурация проекта.
 *
 * @author Evgeniy_Prokhorov
 */

@PropertySource("classpath:application.properties")
@Configuration
public class ApplicationConfig {

    @Value("${spring.datasource.jdbc-url}")
    private String dataSourcePath;
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;
    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriver;

    @Bean
    public DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setJdbcUrl(dataSourcePath);
        dataSourceConfig.setUsername(dataSourceUsername);
        dataSourceConfig.setPassword(dataSourcePassword);
        dataSourceConfig.setDriverClassName(dataSourceDriver);
        return new HikariDataSource(dataSourceConfig);
    }
}