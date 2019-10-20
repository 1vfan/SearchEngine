package com.stefan.configuration.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description: Enable模块注解 {@link ImportSelector}
 * @Author: Stefan
 * @Date: 2019/10/18 2:52 PM
 */
public class EnableDemoConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("<=======ImportSelector=========>");
        /** 相较于直接Import，可添加逻辑控制 */
        return new String[] {Demo1Configuration.class.getName(), Demo2Configuration.class.getName()};
    }
}
