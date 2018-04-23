package com.sdy.mvc01.controller;

import com.sdy.mvc01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //声明为控制器
@RequestMapping(path = "/user") //请求映射
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/index") //请求映射
    public String index(Model model){
        model.addAttribute("list",userService.queryAllUsers());
        return "user/index";
    }

}
