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
 * @Date: 2019/10/9 12:11 PM
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceInterceptor {

    /** 织入点语法，在标注的方法之前之后执行相应操作 */
    @Around("@annotation(dynamic))")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, Dynamic dynamic) throws Throwable {
        try {
            log.info("<----router data source connection---->");
            getDynamicDataSource(dynamic);
            //引用注解的原方法继续执行完毕
            Object result = proceedingJoinPoint.proceed();
            return result;
        }finally {
            //保证下次进程默认还是master数据源
            DynamicRoutingDataSource.clearDataSourceKey();
            log.info("<----restore data source connection--->");
        }
    }

    /** 匹配则设置，否则使用默认数据源 */
    private void getDynamicDataSource(Dynamic dynamic) {
        String value = dynamic.value();
        log.info("value: {}", value);
        for(DynamicDataSourceEnum ddse : DynamicDataSourceEnum.values()) {
            log.info("DynamicDataSourceEnum: {}", ddse);
            if(value.equalsIgnoreCase(ddse.toString())) {
                DynamicRoutingDataSource.setDataSourceKey(ddse);
            }
        }
    }
}
