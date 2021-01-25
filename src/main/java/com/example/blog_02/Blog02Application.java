package com.example.blog_02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blog_02.mapper")
public class Blog02Application {

    public static void main(String[] args) {
        SpringApplication.run(Blog02Application.class, args);
    }

}
