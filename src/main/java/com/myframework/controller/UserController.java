package com.myframework.controller;

import com.myframework.dto.HealthDto;
import com.myframework.dto.ScoreDto;
import com.myframework.dto.StudentDto;
import com.myframework.entity.Student;
import com.myframework.service.HealthService;
import com.myframework.service.ScoreService;
import com.myframework.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/9/24 23:05.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private StudentService studentService;

    @Resource
    private ScoreService scoreService;

    @Resource
    private HealthService healthService;

    //记录登录的学号
    private String studentId;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("studentDto") != null){
            return "redirect:user/index";
        }
        else {
            //清除记录的学号
            studentId = null;
            return "user/login";
        }
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("studentDto") != null){
            return "redirect:index";
        }
        else {
            //清除记录的学号
            studentId = null;
            return "user/login";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(StudentDto studentDto, Model model, HttpServletRequest request) {
        if (studentService.checkLogin(studentDto) != 0) {
            //记录登录的学号
            studentId = studentDto.getStudentId();

            //清除管理员登录信息
            request.getSession().removeAttribute("Admin");

            request.getSession().setAttribute("studentDto", studentDto);
            return "redirect:index";
        }
        else {
            model.addAttribute("login_err", "登录失败!");
            return "user/login";
        }
    }

    //首页
    @RequestMapping(value = "index")
    public String toIndex(Model model){
        StudentDto showHimself = studentService.showHimself(studentId);
        model.addAttribute("showHimself", showHimself);
        return "user/index";
    }

    //修改密码
    @RequestMapping(value = "editpassword", method = RequestMethod.GET)
    public String toEditPassword(){
        return "user/editpassword";
    }

    @RequestMapping(value = "editpassword", method = RequestMethod.POST)
    public String editPassword(StudentDto studentDto, String password){
        studentDto.setStudentId(studentId);
        studentService.editPassword(studentDto, password);
        return "redirect:";
    }

    //修改兴趣
    @RequestMapping(value = "editinterest", method = RequestMethod.GET)
    public String toEditInterest(){

        return "user/editinterest";
    }

    @RequestMapping(value = "editinterest", method = RequestMethod.POST)
    public String editInterest(StudentDto studentDto, String interest){
        studentDto.setStudentId(studentId);
        studentService.editInterest(studentDto, interest);
        return "redirect:";
    }

    //登出
    @RequestMapping(value = {"logoff"}, method = RequestMethod.GET)
    public String logoff(HttpServletRequest request) {
        request.getSession().removeAttribute("studentDto");
        //清除记录的学号
        studentId = null;
        return "index";
    }

    //成绩页
    @RequestMapping(value = "score")
    public String toScore(Model model){
        List<ScoreDto> listHimself = scoreService.listHimself(studentId);
        model.addAttribute("listHimself", listHimself);
        return "user/score";
    }

    //健康页
    @RequestMapping(value = "health")
    public String toHealth(Model model){
        List<HealthDto> listHimself = healthService.listHimself(studentId);
        model.addAttribute("listHimself", listHimself);
        return "user/health";
    }
}