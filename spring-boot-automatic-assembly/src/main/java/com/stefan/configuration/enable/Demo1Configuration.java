package com.stefan.configuration.enable;

import org.springframework.context.annotation.Bean;

/**
 * @Description: 配置类Bean
 * @Author: Stefan
 * @Date: 2019/10/18 2:57 PM
 */
public class Demo1Configuration {

    @Bean
    public String demo1() {
        System.out.println("<=======demo1=========>");
        return "Demo1";
    }

}
