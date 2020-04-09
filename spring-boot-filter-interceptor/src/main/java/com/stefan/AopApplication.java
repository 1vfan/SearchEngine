package com.stefan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2020/4/7 7:11 PM
 */
@SpringBootApplication
@ServletComponentScan
public class AopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);

    }
}
