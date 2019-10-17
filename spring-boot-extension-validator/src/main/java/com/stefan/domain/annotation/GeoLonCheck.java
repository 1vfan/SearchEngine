package com.stefan.domain.annotation;

import com.stefan.manager.GeoConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description: 自定义约束注解
 * @Author: Stefan
 * @Date: 2019/7/17 8:38 AM
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = GeoConstraintValidator.class)
public @interface GeoLonCheck {

    String message() default "经度数值不符合规范";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
