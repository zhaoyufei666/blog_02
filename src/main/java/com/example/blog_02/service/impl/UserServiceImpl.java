package com.example.blog_02.service.impl;

import com.example.blog_02.entity.User;
import com.example.blog_02.mapper.UserMapper;
import com.example.blog_02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean judgeUser(String username, String password) {
        //从数据库中根据username找到对应的值来进行判断
        User user = userMapper.findById(username);
        if (user == null) {
            System.out.println("用户名不存在");
        } else {
            if (user.getPassword().equals(password)) {
                System.out.println("登录成功");
                return true;
            }
            System.out.println("密码错误");
        }
        return false;
    }

    //先判断User中是否有相同的用户命，在进行数据库值的插入
    @Override
    public boolean insertUser(User user) {
        List<User> list = userMapper.findAll();
        for (User user1 : list) {
            //不要用equal因为会有空指针异常
            if (user1.getUsername() == user.getUsername()) {
                return false;
            }
        }
        userMapper.insertUser(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        List<User> list=userMapper.findAll();
        return list;
    }
}
