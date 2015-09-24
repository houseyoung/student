package com.myframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by houseyoung on 15/9/24 23:05.
 */
@Controller
@RequestMapping(value = "/")
public class UserController {
    @RequestMapping(value = {"", "/", "index"})
    public String index(){
        return "index";
    }
}
