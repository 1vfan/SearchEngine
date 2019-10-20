package com.stefan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: SpringBoot启动类
 * @Author: Stefan
 * @Date: 2019/10/18 10:14 AM
 */
@SpringBootApplication
public class AssemblyApplication {

    public static void main(String[] args) {
        System.out.println("AssemblyApplication start");
        SpringApplication.run(AssemblyApplication.class, args);
    }

}
