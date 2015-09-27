package com.myframework.controller;

import com.myframework.entity.User;
import com.myframework.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by houseyoung on 15/9/27 16:40.
 */
@Controller
@RequestMapping(value = "role1")
public class Role1Controller {
    @RequestMapping(value = "")
    public String toRole1(){
        return "role1/role1";
    }
}
