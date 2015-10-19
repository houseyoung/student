package com.myframework.controller;

import com.myframework.entity.User;
import com.myframework.service.StudentService;
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
    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String toLogin()
    {
//        if (request.getSession().getAttribute("role1") != null){
//            return "role1/role1";
//        }
//        else if (request.getSession().getAttribute("role2") != null){
//            return "role2/role2";
//        }
//        else {
            return "index";
//        }
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String login(User role1, User role2, Model model, HttpServletRequest request) {
//        String pwd = role1.getPassword();
//        if (userService.checkRole(role1) == 1) {
//            request.getSession().setAttribute("role1", role1);
//            return "redirect:role1";
//        }
//        else if (userService.checkRole(role2) == 2) {
//            request.getSession().setAttribute("role2", role2);
//            return "redirect:role2";
//        }
//        else {
//            model.addAttribute("login_err", "登录失败!");
//            return "index";
//        }
//    }

    @RequestMapping(value = "forbidden")
    public String toForbidden(){
        return "forbidden";
    }
}