package com.myframework.controller;

import com.myframework.entity.User;
import com.myframework.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/9/27 14:37.
 */
@Controller
@RequestMapping(value = "")
public class IndexController {
    @Resource
    private UserService userService;

    @RequestMapping(value = {"", "/", "login"}, method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("role1") != null){
            return "role1";
        }
        else if (request.getSession().getAttribute("role2") != null){
            return "role2";
        }
        else {
            return "login";
        }
    }

    @RequestMapping(value = {"role1"}, method = RequestMethod.GET)
    public String toRole1() {
        return "role1";
    }

    @RequestMapping(value = {"role2"}, method = RequestMethod.GET)
    public String toRole2() {
        return "role2";
    }

    //Login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) {
        //If pass, set attribute to session, then redirect to index page.
        if (userService.checkLogin(user)) {
            if (userService.checkRole(user) == 1) {
                request.getSession().setAttribute("role1", user);
                return "redirect:role1";
            } else {
                request.getSession().setAttribute("role2", user);
                return "redirect:role2";
            }
        }
        //If not pass, send error attribute.
        else {
            model.addAttribute("login_err", "登录失败!");
            return "login";
        }
    }
}