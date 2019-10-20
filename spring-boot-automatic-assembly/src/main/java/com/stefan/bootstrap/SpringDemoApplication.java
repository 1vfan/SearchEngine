package com.stefan.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: 自动装配测试启动类
 * @Author: Stefan
 * @Date: 2019/10/18 3:45 PM
 */
@EnableAutoConfiguration
public class SpringDemoApplication {

    public static void main(String[] args) {
        System.out.println("SpringDemoApplication start");
        ConfigurableApplicationContext context =
                SpringApplication.run(SpringDemoApplication.class, args);
        System.out.println(context.getBean("demo1", String.class));
        System.out.println(context.getBean("demo2", String.class));
        context.close();
    }
}
