package com.example.blog_02.mapper;

import com.example.blog_02.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    //通过username获得对应的User对象
    @Select("select * from user where username=#{username}")
    User findById(String username);

    //查询所有
    @Select("select * from user")
    List<User> findAll();

    //向数据库插入数据
    @Insert("insert into user(user.username,user.password) values(#{user.username},#{user.password})")
    void insertUser(@Param("user") User user);
}

