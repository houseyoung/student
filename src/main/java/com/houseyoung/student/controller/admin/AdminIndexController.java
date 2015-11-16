package com.houseyoung.student.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by houseyoung on 15/11/14 23:09.
 */
@Controller
@RequestMapping(value = "admin")
public class AdminIndexController {
    //管理员首页
    @RequestMapping(value = "index")
    public String toIndex(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            return "admin/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

    //登出
    @RequestMapping(value = {"logoff"}, method = RequestMethod.GET)
    public String logoff(HttpServletRequest request, Model model) throws Exception{
        try {
            request.getSession().removeAttribute("admin");
            return "redirect:../index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
}
