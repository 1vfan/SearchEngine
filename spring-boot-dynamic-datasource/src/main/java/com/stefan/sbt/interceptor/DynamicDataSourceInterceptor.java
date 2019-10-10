package com.stefan.sbt.interceptor;

import com.stefan.sbt.configuration.DynamicRoutingDataSource;
import com.stefan.sbt.domain.annotation.Dynamic;
import com.stefan.sbt.domain.enums.DynamicDataSourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description: 配置切面拦截器，增强被注解的方法
 * @Author: Stefan
 * @Date: 2019/7/11 12:11 PM
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceInterceptor {

    /** 织入，在注解标注的方法前后执行相应操作 */
    @Around("@annotation(dynamic))")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, Dynamic dynamic) throws Throwable {
        try {
            setDynamicDataSource(dynamic);
            Object result = proceedingJoinPoint.proceed();
            return result;
        }finally {
            //保证下一次进程使用默认数据源
            DynamicRoutingDataSource.clearDataSourceKey();
            log.info("Clear DataSourceKey in TheardLocal");
        }
    }

    /** 匹配则使用注解设置，否则使用默认数据源 */
    private void setDynamicDataSource(Dynamic dynamic) {
        String value = dynamic.value();
        for(DynamicDataSourceEnum ddse : DynamicDataSourceEnum.values()) {
            if(value.equalsIgnoreCase(ddse.toString())) {
                log.info("Dynamic Annotation value is {}", ddse);
                DynamicRoutingDataSource.setDataSourceKey(ddse);
                break;
            }
        }
    }
}