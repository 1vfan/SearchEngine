package com.stefan.controller.demo;

import com.stefan.domain.entity.Demo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description: 测试3，验证fail_fast模式
 * @Author: Stefan
 * @Date: 2019/7/16 4:47 PM
 */
@RestController
public class Demo3Controller {

    /** @Valid注解非基础类型，约束生效 */
    @PostMapping("/demo3")
    public String demo3(@Valid Demo demo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            for(FieldError msg : bindingResult.getFieldErrors()) {
                System.out.println("demo3: " + msg.getDefaultMessage());
            }
        }
        return "demo3 success";
    }

}
