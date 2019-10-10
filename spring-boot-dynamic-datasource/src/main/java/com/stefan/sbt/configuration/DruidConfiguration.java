package com.stefan.sbt.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description: {@link DataSourceBuilder} 解析连接池配置创建Druid数据源并配置监控台
 * @Author: Stefan
 * @Date: 2019/7/11 6:34 PM
 */
@Slf4j
@Configuration
@EnableTransactionManagement
public class DruidConfiguration {

    /** 自定义数据库连接池的数据源类型 */
    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    /** 默认主数据源 */
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "druid.master")
    public DataSource masterDataSource() {
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        log.info("========MASTER: {}=========", masterDataSource);
        return masterDataSource;
    }

    /** 从数据源 */
    @Bean(name = "slave1DataSource")
    @ConfigurationProperties(prefix = "druid.slave1")
    public DataSource slaveDataSource(){
        DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        log.info("========SLAVE1: {}=========", slaveDataSource);
        return slaveDataSource;
    }

    /** 等同传统Servlet注册 */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        /** Druid控制台 */
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("allow", "localhost");
        reg.addInitParameter("deny","/deny");
        reg.addInitParameter("loginUsername", "stefan");
        reg.addInitParameter("loginPassword", "stefan");
        log.info(" druid console manager init : {} ", reg);
        return reg;
    }

    /** 等同传统Filter注册 */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        /** Web和Druid数据源之间的管理关联监控统计 */
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico, /druid/*");
        log.info(" druid filter register : {} ", filterRegistrationBean);
        return filterRegistrationBean;
    }

}
