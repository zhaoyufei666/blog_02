package com.example.blog_02.controller;

import com.example.blog_02.entity.User;
import com.example.blog_02.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RegisterController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public String Register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean b = userService.insertUser(user);
        if (b){
            session.setAttribute("LoginUser", user);
            return "success";
        }
        else
            return "false";
    }
}
