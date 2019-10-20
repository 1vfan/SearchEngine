package com.stefan.configuration.enable;

import org.springframework.context.annotation.Bean;

/**
 * @Description: 配置类Bean
 * @Author: Stefan
 * @Date: 2019/10/18 2:59 PM
 */
public class Demo2Configuration {

    @Bean
    public String demo2() {
        System.out.println("<=======demo2=========>");
        return "Demo2";
    }

}
