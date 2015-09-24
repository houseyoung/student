package com.myframework.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myframework.entity.User;
import com.myframework.service.UserService;

/**
 * Created by houseyoung on 15/9/24 22:29.
 */
public class UserTest {
    private UserService userService;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
                ,"classpath:spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setId(7);
        user.setUsername("admin");
        System.out.println(userService.insertUser(user));
    }
}
