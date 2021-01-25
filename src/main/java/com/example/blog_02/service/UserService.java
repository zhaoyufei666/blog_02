package com.example.blog_02.service;

import com.example.blog_02.entity.User;

import java.util.List;

public interface UserService {
    boolean judgeUser(String username, String password);
    boolean insertUser(User user);
    List<User> findAll();
}
