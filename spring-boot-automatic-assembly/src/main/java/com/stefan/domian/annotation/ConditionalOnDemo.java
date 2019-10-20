package com.stefan.domian.annotation;

import com.stefan.configuration.conditional.SpringDemoCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Description: 自定义条件注解
 * @Author: Stefan
 * @Date: 2019/10/18 3:15 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(SpringDemoCondition.class)
public @interface ConditionalOnDemo {

    String name();

    String value();
}
