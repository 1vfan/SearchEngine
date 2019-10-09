package com.stefan.sbt.domain.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义注解
 * @Author: Stefan
 * @Date: 2019/10/8 7:23 PM
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dynamic {

    String value() default "";

}
