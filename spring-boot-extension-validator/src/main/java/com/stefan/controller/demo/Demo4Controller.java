package com.stefan.controller.demo;

import com.stefan.domain.entity.Demo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description: 测试4：验证自定义约束注解
 * @Author: Stefan
 * @Date: 2019/7/17 9:20 AM
 */
@RestController
public class Demo4Controller {

    /**  */
    @PostMapping("/demo4")
    public String demo4(@Valid Demo demo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            for(FieldError msg : bindingResult.getFieldErrors()) {
                System.out.println("demo4: " + msg.getDefaultMessage());
            }
        }
        return "demo4 success";
    }

}