package com.stefan.controller.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @Description: 测试1，@Valid注解基础类型参数不会生效
 * @Author: Stefan
 * @Date: 2019/7/16 4:47 PM
 */
@RestController
public class Demo1Controller {

    /** 无效约束 */
    @PostMapping("/demo1")
    public String demo1(@Valid @Min(value = 18,  message = "未成年止步") int age) {
        return "demo1 success";
    }

}
