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
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/LoginForm",method = RequestMethod.GET)
    public String LoginForm(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session
    ) {
        boolean b = userService.judgeUser(username, password);
        if (b) {
            //把值放进session中
            User user = new User();
            session.setAttribute("LoginUser", user);
            return "success";
        } else {
            return "false";
        }
    }
}
