package com.stefan.configuration.conditional;

import com.stefan.domian.annotation.ConditionalOnDemo;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Description: 条件装配 {@link Condition}
 * @Author: Stefan
 * @Date: 2019/10/18 3:18 PM
 */
public class SpringDemoCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnDemo.class.getName());

        String propertyName = String.valueOf(attributes.get("name"));
        System.out.println("<=======name: " + propertyName + "=========>");
        String propertyValue = String.valueOf(attributes.get("value"));
        System.out.println("<=======value: " + propertyValue + "=========>");
        String javaPropertyValue = System.getProperty(propertyName);
        System.out.println("<=======system value: " + javaPropertyValue + "=========>");

        return propertyValue.equals(javaPropertyValue);

    }
}
