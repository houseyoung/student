package com.houseyoung.student.controller;

import com.houseyoung.student.dto.AdminDto;
import com.houseyoung.student.dto.StudentDto;
import com.houseyoung.student.entity.Admin;
import com.houseyoung.student.service.AdminService;
import com.houseyoung.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * LoginController
 *
 * @author: yangch
 * @time: 2015/11/10 16:01
 */
@Controller
@RequestMapping(value = "")
public class LoginController {
    @Resource
    private AdminService adminService;

    @Resource
    private StudentService studentService;

    //去管理员登录页
    @RequestMapping(value = {"admin", "admin/", "admin/login"}, method = RequestMethod.GET)
    public String toAdminLogin(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("admin") != null) {
                //显示右上角个人信息
                String username = (String) request.getSession().getAttribute("admin");
                model.addAttribute("username", username);

                return "admin/index";
            } else if (request.getSession().getAttribute("studentDto") != null || request.getSession().getAttribute("instructor") != null){
                //若已使用学生、管理员身份登录，则跳转至屏蔽页
                return "forbidden";
            } else {
                return "admin/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

    //去辅导员登录页
    @RequestMapping(value = {"instructor", "instructor/", "instructor/login"}, method = RequestMethod.GET)
    public String toInstructorLogin(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("instructor") != null) {
                //显示右上角个人信息
                String username = (String) request.getSession().getAttribute("instructor");
                model.addAttribute("username", username);

                return "instructor/index";
            } else if (request.getSession().getAttribute("studentDto") != null || request.getSession().getAttribute("admin") != null){
                //若已使用学生、管理员身份登录，则跳转至屏蔽页
                return "forbidden";
            } else {
                return "admin/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

    //管理员、辅导员登录
    @RequestMapping(value = "admin/login", method = RequestMethod.POST)
    public String adminAndInstructorLogin(Admin admin, Admin instructor, Model model, HttpServletRequest request) throws Exception{
        try {
            if (adminService.checkRole(admin) == 1) {
                //清除学生、辅导员登录信息
                request.getSession().removeAttribute("studentDto");
                request.getSession().removeAttribute("instructor");

                //在Session中记录Username，使得在其他类中可以通过Username得到其他信息
                request.getSession().setAttribute("admin", admin.getUsername());
                return "redirect:index";
            } else if (adminService.checkRole(instructor) == 2) {
                //清除学生、管理员登录信息
                request.getSession().removeAttribute("studentDto");
                request.getSession().removeAttribute("admin");

                //在Session中记录Username，使得在其他类中可以通过Username得到其他信息
                request.getSession().setAttribute("instructor", instructor.getUsername());
                return "redirect:../instructor/index";
            } else {
                model.addAttribute("error", "登录失败!");
                return "admin/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/login/login";
        }
    }

    //去学生登录页
    @RequestMapping(value = {"student", "student/", "student/login"}, method = RequestMethod.GET)
    public String toStudentLogin(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("studentDto") != null) {
                //显示右上角个人信息
                String studentId = (String) request.getSession().getAttribute("studentDto");
                model.addAttribute("studentName", studentService.showHimself(studentId).getStudentName());

                return "student/index";
            } else if (request.getSession().getAttribute("instructor") != null || request.getSession().getAttribute("admin") != null){
                //若已使用管理员/辅导员身份登录，则跳转至屏蔽页
                return "forbidden";
            } else {
                return "student/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/login/login";
        }
    }

    @RequestMapping(value = "student/login", method = RequestMethod.POST)
    public String studentLogin(StudentDto studentDto, Model model, HttpServletRequest request) throws Exception{
        try {
            if (studentService.checkLogin(studentDto) != 0) {
                //清除管理员、辅导员登录信息
                request.getSession().removeAttribute("admin");
                request.getSession().removeAttribute("instructor");

                //在Session中记录StudentId
                request.getSession().setAttribute("studentDto", studentDto.getStudentId());
                return "redirect:index";
            } else {
                model.addAttribute("error", "登录失败!");
                return "student/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/login/login";
        }
    }
}