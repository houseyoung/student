package com.houseyoung.student.controller;

import com.houseyoung.student.dto.AdminDto;
import com.houseyoung.student.entity.Admin;
import com.houseyoung.student.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/10/23 22:24.
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    //记录登录的ID
    private int id;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("admin") != null){
            return "redirect:admin/index";
        }
        else if (request.getSession().getAttribute("instructor") != null){
            return "redirect:index1";
        }
        else {
            //清除记录的ID
            id = 0;
            return "admin/login";
        }
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("admin") != null){
            return "redirect:index";
        }
        else if (request.getSession().getAttribute("instructor") != null){
            return "redirect:index1";
        }
        else {
            //清除记录的ID
            id = 0;
            return "admin/login";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Admin admin, Admin instructor, Model model, HttpServletRequest request) {
        if (adminService.checkRole(admin) == 1) {
            //记录登录的ID
            id = adminService.getIdByUsername(admin);

            //清除学生、辅导员登录信息
            request.getSession().removeAttribute("studentDto");
            request.getSession().removeAttribute("instructor");

            //在Session中记录Username，使得在其他类中可以通过Username得到其他信息
            request.getSession().setAttribute("admin", admin.getUsername());
            return "redirect:index";
        }
        else if (adminService.checkRole(instructor) == 2) {
            //记录登录的ID
            id = adminService.getIdByUsername(instructor);

            //清除学生、辅导员登录信息
            request.getSession().removeAttribute("studentDto");
            request.getSession().removeAttribute("admin");

            //在Session中记录Username，使得在其他类中可以通过Username得到其他信息
            request.getSession().setAttribute("instructor", instructor.getUsername());
            return "redirect:index1";
        }
        else {
            model.addAttribute("login_err", "登录失败!");
            return "admin/login";
        }
    }

    //管理员首页
    @RequestMapping(value = "index")
    public String toIndex(){
        return "admin/index";
    }

    //辅导员首页
    @RequestMapping(value = "index1")
    public String toIndex1(){
        return "admin/index1";
    }

    //登出
    @RequestMapping(value = {"logoff"}, method = RequestMethod.GET)
    public String logoff(HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        request.getSession().removeAttribute("instructor");
        //清除记录的ID
        id = 0;
        return "index";
    }

    //显示、搜索
    @RequestMapping(value = {"admin", "admin/"})
    public String toList(String keywords, Model model){
        //首先显示个人信息
        Admin showHimself = adminService.showHimself(id);
        model.addAttribute("showHimself", showHimself);

        //再显示全部人信息
        List<Admin> listAdmin = adminService.listAdmin(keywords, id);
        model.addAttribute("listAdmin", listAdmin);
        return "admin/admin/list";
    }

    //增加
    @RequestMapping(value = "admin/insert", method = RequestMethod.GET)
    public String toInsert(){
        return "admin/admin/insert";
    }

    @RequestMapping(value = "admin/insert", method = RequestMethod.POST)
    public String insert(Admin admin){
        adminService.insertAdmin(admin);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "admin/delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        adminService.delete(id);
        return "redirect:";
    }

    //修改个人信息
    @RequestMapping(value = "admin/edithimself", method = RequestMethod.GET)
    public String toEditHimself(Model model){
        //显示原有信息
        Admin showHimself = adminService.showHimself(id);
        model.addAttribute("showHimself", showHimself);

        return "admin/admin/edithimself";
    }

    @RequestMapping(value = "admin/edithimself", method = RequestMethod.POST)
    public String editHimself(Admin admin, String username, String password, String name){
        admin.setId(id);
        adminService.editHimself(admin, username, password, name);
        return "redirect:";
    }

    //查看辅导员个人信息
    @RequestMapping(value = "instructor/showhimself")
    public String toShowInstructorHimself(Model model){
        AdminDto showInstructorHimself = adminService.showInstructorHimself(id);
        model.addAttribute("showInstructorHimself", showInstructorHimself);
        return "admin/instructor/showhimself";
    }

    //辅导员修改个人信息
    @RequestMapping(value = "instructor/edithimself", method = RequestMethod.GET)
    public String toEditInstructorHimself(Model model){
        //显示原有信息
        AdminDto showInstructorHimself = adminService.showInstructorHimself(id);
        model.addAttribute("showInstructorHimself", showInstructorHimself);

        return "admin/instructor/edithimself";
    }

    @RequestMapping(value = "instructor/edithimself", method = RequestMethod.POST)
    public String editInstructorHimself(Admin admin, String username, String password, String name){
        admin.setId(id);
        adminService.editInstructorHimself(admin, username, password, name);
        return "redirect:";
    }
}