package com.macaitech.biz.multimodule.config;


import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

/**
 * MybatisPlus 配置
 *
 * @author mq
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.macaitech.biz.multimodule.dao")
@Order(2)
public class MybatisPlusConfig {
	
	@Resource(name = "dataSource")
	private DataSource routingDataSource;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(routingDataSource);
	}
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * Mybatis 配置
     *
     * @param metaObjectHandler 填充器
     * @return SqlSessionFactory
     * @throws Exception 异常
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(PaginationInterceptor paginationInterceptor) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        // 配置多数据源
        //sqlSessionFactory.setDataSource(multipleDataSource(db1(), db2()));
        sqlSessionFactory.setDataSource(routingDataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        //sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        // 实体扫描，多个package用逗号或者分号分隔
        sqlSessionFactory.setTypeAliasesPackage("com.macaitech.biz.multimodule.common.model");
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        // 主键类型  AUTO:"数据库ID自增", INPUT:"用户输入ID",ID_WORKER:"全局唯一ID (数字类型唯一ID)", UUID:"全局唯一ID UUID";
        dbConfig.setIdType(IdType.AUTO);
        // 字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
        dbConfig.setFieldStrategy(FieldStrategy.NOT_NULL);
        // 数据库大写下划线转换
        dbConfig.setCapitalMode(true);
        // 逻辑删除配置
        dbConfig.setLogicDeleteValue("1");
        dbConfig.setLogicNotDeleteValue("0");
        dbConfig.setDbType(DbType.MYSQL);

        GlobalConfig globalConfig = new GlobalConfig();
        //#刷新mapper 调试神器
        globalConfig.setRefresh(true);
        globalConfig.setDbConfig(dbConfig);
        //globalConfig.setMetaObjectHandler(metaObjectHandler);
        sqlSessionFactory.setGlobalConfig(globalConfig);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        configuration.setCallSettersOnNulls(true);
        sqlSessionFactory.setConfiguration(configuration);

        sqlSessionFactory.setPlugins(new Interceptor[]{
                //添加分页功能
                paginationInterceptor
        });
        return sqlSessionFactory.getObject();
    }

}
