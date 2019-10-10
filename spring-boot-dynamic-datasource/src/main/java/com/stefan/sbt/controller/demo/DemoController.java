package com.stefan.sbt.controller.demo;

import com.stefan.sbt.domain.entity.Demo;
import com.stefan.sbt.service.demo.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 测试Controller
 * @Author: Stefan
 * @Date: 2019/7/11 9:33 AM
 */
@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/findDemo")
    public Demo findUserByName(@RequestParam String name) {
        return demoService.findDemoByName(name);
    }

}
