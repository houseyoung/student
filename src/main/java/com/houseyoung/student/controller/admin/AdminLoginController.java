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
}