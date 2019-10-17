package com.stefan.controller.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * @Description: 测试2，添加@Validated注解，约束生效
 * @Author: Stefan
 * @Date: 2019/7/16 5:07 PM
 */
@Validated
@RestController
public class Demo2Controller {

    /** 有效约束 */
    @PostMapping("/demo2")
    public String demo2(@Min(value = 18,  message = "未成年止步") int age) {
        return "demo2 success";
    }

}