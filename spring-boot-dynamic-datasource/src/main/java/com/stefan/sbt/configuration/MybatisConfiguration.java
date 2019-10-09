package com.stefan.sbt.configuration;

import com.stefan.sbt.domain.enums.DynamicDataSourceEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 注入多数据源
 * @Author: Stefan
 * @Date: 2019/10/8 7:27 PM
 */
@Configuration
@AutoConfigureAfter({DruidConfiguration.class})
public class MybatisConfiguration {

    @Resource
    private DataSource masterDataSource;

    @Resource
    private DataSource slave1DataSource;

    /** 将多数据源Bean与SqlSessionFactory关联 */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "dynamicRoutingDataSource")
    public DynamicRoutingDataSource dataSource() {
        DynamicRoutingDataSource proxy = new DynamicRoutingDataSource();
        Map<Object, Object> targetDataSource = new ConcurrentHashMap<>(2);
        targetDataSource.put(DynamicDataSourceEnum.MASTER, masterDataSource);
        targetDataSource.put(DynamicDataSourceEnum.SLAVE1, slave1DataSource);
        proxy.setDefaultTargetDataSource(masterDataSource);
        proxy.setTargetDataSources(targetDataSource);
        return proxy;
    }

}