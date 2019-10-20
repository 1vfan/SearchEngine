package com.stefan.domian.annotation;

import com.stefan.configuration.enable.EnableDemoConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description: 自定义模块注解
 * @Author: Stefan
 * @Date: 2019/10/18 2:50 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnableDemoConfigurationSelector.class)
public @interface EnableDemoConfiguration {
}
