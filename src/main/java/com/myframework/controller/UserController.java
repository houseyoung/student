package com.myframework.controller;

import com.myframework.entity.User;
import com.myframework.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by houseyoung on 15/9/24 23:05.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "")
    public String toUserList(Model model){
        List<User> listUser = userService.listUser();
        model.addAttribute("listUser", listUser);
        return "user/user";
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsertUser() {
        return "user/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insertUser(User user){
        userService.insert(user);
        return "redirect:";
    }
}
