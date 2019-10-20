package com.stefan.configuration.auto;

import com.stefan.domian.annotation.ConditionalOnDemo;
import com.stefan.domian.annotation.EnableDemoConfiguration;
import com.stefan.domian.annotation.SpringDemoConfiguration;

/**
 * @Description: 自动装配 = 模式注解 + 模块注解 + 条件注解
 * @Author: Stefan
 * @Date: 2019/10/18 3:00 PM
 */
@SpringDemoConfiguration
@EnableDemoConfiguration
@ConditionalOnDemo(name = "user.name", value = "stefan")
public class SpringDemoAutoConfiguration {
}
