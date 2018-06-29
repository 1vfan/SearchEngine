package com.fan.web.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lf on 2018/6/29.
 */
@Controller
public class UserController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "吕凡");
        return "index";
    }
}
