package com.houseyoung.student.controller.instructor;

import com.houseyoung.student.entity.Admin;
import com.houseyoung.student.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by houseyoung on 15/11/14 23:25.
 */
@Controller
@RequestMapping(value = "instructor")
public class InstructorIndexController {
    @Resource
    private AdminService adminService;

    //辅导员首页
    @RequestMapping(value = "index")
    public String toIndex(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("instructor");
            model.addAttribute("username", username);

            return "instructor/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

    //修改个人信息
    @RequestMapping(value = "edithimself", method = RequestMethod.GET)
    public String toEditHimself(Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ID
            String username = (String) request.getSession().getAttribute("instructor");
            int id = 0;
            if (username != null) {
                id = adminService.getIdByUsername(username);
            }

            //显示右上角个人信息
            model.addAttribute("username", username);

            //显示原有信息
            Admin showHimself = adminService.showHimself(id);
            model.addAttribute("showHimself", showHimself);
            return "instructor/edithimself";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/index";
        }
    }

    @RequestMapping(value = "edithimself", method = RequestMethod.POST)
    public String editHimself(Admin admin, String username, String password, String name, Model model) throws Exception{
        try {
            int id = 0;
            if (username != null) {
                id = adminService.getIdByUsername(username);
            }

            //显示右上角个人信息
            model.addAttribute("username", username);

            admin.setId(id);
            adminService.editHimself(admin, username, password, name);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/edithimself";
        }
    }

    //登出
    @RequestMapping(value = {"logoff"}, method = RequestMethod.GET)
    public String logoff(HttpServletRequest request, Model model) throws Exception{
        try {
            request.getSession().removeAttribute("instructor");
            return "redirect:../index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
}
