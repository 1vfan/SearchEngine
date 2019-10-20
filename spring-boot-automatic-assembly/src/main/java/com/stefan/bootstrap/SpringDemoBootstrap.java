package com.stefan.bootstrap;

import com.stefan.configuration.auto.SpringDemoAutoConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: 自定义自动装配注解类测试
 * @Author: Stefan
 * @Date: 2019/10/18 3:35 PM
 */
public class SpringDemoBootstrap {

    public static void main(String[] args) {
        System.out.println("SpringDemoBootstrap start");
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(SpringDemoAutoConfiguration.class)
                .web(WebApplicationType.NONE)
                .run(args);
        System.out.println(context.getBean("demo1", String.class));
        System.out.println(context.getBean("demo2", String.class));
        context.close();
    }

}
