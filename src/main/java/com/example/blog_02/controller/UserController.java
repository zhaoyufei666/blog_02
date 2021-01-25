package com.example.blog_02.controller;

import com.example.blog_02.entity.User;
import com.example.blog_02.service.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/findAll")
    public Object findAll(Model model,@RequestParam(defaultValue = "1", name = "pageNum") int pageNum) {
        //设置起始页面pageNum和每页的个数pageSize:5
        PageHelper.startPage(pageNum, 5);
        List<User> list = userService.findAll();
        PageInfo<User> pageInfo=new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return pageInfo;
    }
}
