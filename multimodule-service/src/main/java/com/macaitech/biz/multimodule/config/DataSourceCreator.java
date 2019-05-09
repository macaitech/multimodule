/**
 * 
 */
package com.macaitech.biz.multimodule.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author yuhui.tang
 *
 */
@Configuration
@Order(1)
public class DataSourceCreator {
	
	@Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.multimodule" )
    public DataSource multimodule() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
