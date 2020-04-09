package com.stefan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2020/4/7 8:06 PM
 */
@RestController
@RequestMapping("/hello")
public class TimerController {

    @GetMapping(value = "/world")
    public void test(HttpServletResponse response) throws IOException {
        System.out.println("controller-----------");
        response.getWriter().print("Hello World");
    }

}
