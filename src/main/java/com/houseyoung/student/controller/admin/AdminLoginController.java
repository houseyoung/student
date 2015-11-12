package com.houseyoung.student.controller.admin;

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
 * AdminLoginController
 *
 * @author: yangch
 * @time: 2015/11/10 16:01
 */
@Controller
@RequestMapping(value = "admin")
public class AdminLoginController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("admin") != null) {
                //显示右上角个人信息
                String username = (String) request.getSession().getAttribute("admin");
                model.addAttribute("username", username);

                return "admin/index";
            } else {
                return "admin/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public String toLogin1(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("admin") != null) {
                //显示右上角个人信息
                String username = (String) request.getSession().getAttribute("admin");
                model.addAttribute("username", username);

                return "admin/index";
            } else {
                return "admin/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Admin admin, Admin instructor, Model model, HttpServletRequest request) throws Exception{
        try {
            if (adminService.checkRole(admin) == 1) {

                //清除学生、辅导员登录信息
                request.getSession().removeAttribute("studentDto");
                request.getSession().removeAttribute("instructor");

                //在Session中记录Username，使得在其他类中可以通过Username得到其他信息
                request.getSession().setAttribute("admin", admin.getUsername());
                return "redirect:index";
            } else {
                model.addAttribute("error", "登录失败!");
                return "admin/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

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
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
//
//    //显示、搜索
//    @RequestMapping(value = {"admin", "admin/"})
//    public String toList(String keywords, Model model) throws Exception{
//        try {
//            //首先显示个人信息
//            Admin showHimself = adminService.showHimself(id);
//            model.addAttribute("showHimself", showHimself);
//
//            //再显示全部人信息
//            List<Admin> listAdmin = adminService.listAdmin(keywords, id);
//            model.addAttribute("listAdmin", listAdmin);
//            return "admin/admin/list";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/admin/list";
//        }
//    }
//
//    //增加
//    @RequestMapping(value = "admin/insert", method = RequestMethod.GET)
//    public String toInsert(Model model) throws Exception{
//        try {
//            return "admin/admin/insert";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/admin/list";
//        }
//    }
//
//    @RequestMapping(value = "admin/insert", method = RequestMethod.POST)
//    public String insert(Admin admin, Model model) throws Exception{
//        try {
//            adminService.insertAdmin(admin);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/admin/insert";
//        }
//    }
//
//    //删除
//    @RequestMapping(value = "admin/delete", method = RequestMethod.GET)
//    public String toDelete(Integer id, Model model) throws Exception{
//        try {
//            adminService.delete(id);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/admin/list";
//        }
//    }
//
//    //修改个人信息
//    @RequestMapping(value = "admin/edithimself", method = RequestMethod.GET)
//    public String toEditHimself(Model model) throws Exception{
//        try {
//            //显示原有信息
//            Admin showHimself = adminService.showHimself(id);
//            model.addAttribute("showHimself", showHimself);
//            return "admin/admin/edithimself";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/admin/list";
//        }
//    }
//
//    @RequestMapping(value = "admin/edithimself", method = RequestMethod.POST)
//    public String editHimself(Admin admin, String username, String password, String name, Model model) throws Exception{
//        try {
//            admin.setId(id);
//            adminService.editHimself(admin, username, password, name);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/admin/edithimself";
//        }
//    }
//
//    //查看辅导员个人信息
//    @RequestMapping(value = "instructor/showhimself")
//    public String toShowInstructorHimself(Model model) throws Exception{
//        try {
//            AdminDto showInstructorHimself = adminService.showInstructorHimself(id);
//            model.addAttribute("showInstructorHimself", showInstructorHimself);
//            return "admin/instructor/showhimself";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/instructor/showhimself";
//        }
//    }
//
//    //辅导员修改个人信息
//    @RequestMapping(value = "instructor/edithimself", method = RequestMethod.GET)
//    public String toEditInstructorHimself(Model model) throws Exception{
//        try {
//            //显示原有信息
//            AdminDto showInstructorHimself = adminService.showInstructorHimself(id);
//            model.addAttribute("showInstructorHimself", showInstructorHimself);
//            return "admin/instructor/edithimself";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/instructor/showhimself";
//        }
//    }
//
//    @RequestMapping(value = "instructor/edithimself", method = RequestMethod.POST)
//    public String editInstructorHimself(Admin admin, String username, String password, String name, Model model) throws Exception{
//        try {
//            admin.setId(id);
//            adminService.editInstructorHimself(admin, username, password, name);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/instructor/edithimself";
//        }
//    }
}