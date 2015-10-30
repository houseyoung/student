package com.houseyoung.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by houseyoung on 15/9/27 14:37.
 */
@Controller
@RequestMapping(value = "")
public class IndexController {
    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("admin") != null){
            return "admin/index";
        }
        else if (request.getSession().getAttribute("instructor") != null){
            return "admin/index1";
        }
        else if (request.getSession().getAttribute("studentDto") != null){
            return "user/index";
        }
        else {
            return "index";
        }
    }

    @RequestMapping(value = "forbidden")
    public String toForbidden(){
        return "forbidden";
    }
}