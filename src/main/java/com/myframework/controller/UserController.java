package com.myframework.controller;

import com.myframework.entity.User;
import com.myframework.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by houseyoung on 15/9/24 23:05.
 */
@Controller
@RequestMapping(value = "")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "user")
    public String index(Integer id, Model model){
        List<User> listUser = userService.listUser();
        model.addAttribute("listUser", listUser);
        return "user";
    }
}
