package com.houseyoung.student.controller.student;

import com.houseyoung.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by houseyoung on 15/9/24 23:05.
 */
@Controller
@RequestMapping(value = "student")
public class StudentIndexController {
    @Resource
    private StudentService studentService;

    //首页
    @RequestMapping(value = "index")
    public String toIndex(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String studentId = (String) request.getSession().getAttribute("studentDto");
            model.addAttribute("studentName", studentService.showHimself(studentId).getStudentName());
            model.addAttribute("studentId", studentId);

            return "student/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/index";
        }
    }

    //登出
    @RequestMapping(value = {"logoff"}, method = RequestMethod.GET)
    public String logoff(HttpServletRequest request, Model model) throws Exception{
        try {
            request.getSession().removeAttribute("studentDto");
            return "redirect:../index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
}