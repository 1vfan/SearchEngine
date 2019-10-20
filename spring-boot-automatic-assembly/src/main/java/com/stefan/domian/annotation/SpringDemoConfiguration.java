package com.stefan.domian.annotation;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @Description: 自定义模式注解 {@link Configuration}
 * @Author: Stefan
 * @Date: 2019/10/18 2:44 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringDemoConfiguration {
}
