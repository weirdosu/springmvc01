package com.sdy.mvc01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdy.mvc01.entity.User;
import com.sdy.mvc01.service.UserService;
import com.sdy.mvc01.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/user/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(User user){
        userService.addUser(user);
        return "redirect:/user/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "user/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(User user){
        userService.editUser(user);
        return "redirect:/user/index";
    }
    /**jsp返回日期格式修改*/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/users")
    public ModelAndView users(){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject(userService.queryAllUsers());
        return mav;
    }
    /**json值*/
    @RequestMapping(value = "/userJson",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String userJson(){
        return JsonUtil.getJson(userService.queryAllUsers(),"yyyy-MM-dd");
    }
}
