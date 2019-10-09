package com.stefan.sbt.configuration;

import com.stefan.sbt.domain.enums.DynamicDataSourceEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: 代理类 {@link AbstractRoutingDataSource}，重写方法根据当前线程中的key路由获取到对应的数据源
 * @Author: Stefan
 * @Date: 2019/10/8 7:08 PM
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {


    private static final ThreadLocal<DynamicDataSourceEnum> dataSourceKey =
            new ThreadLocal<>();

    /** 重写路由方法逻辑 */
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceKey();
    }

    /** 提供设置数据源key方法 */
    public static void setDataSourceKey(DynamicDataSourceEnum dataSourceTypeEnum) {
        dataSourceKey.set(dataSourceTypeEnum);
    }

    /** 未设定则使用默认主数据源 */
    public static DynamicDataSourceEnum getDataSourceKey() {
        return dataSourceKey == null ? DynamicDataSourceEnum.MASTER : dataSourceKey.get();
    }

    /**提供清空数据源key方法 */
    public static void clearDataSourceKey() {
        dataSourceKey.remove();
    }

}
