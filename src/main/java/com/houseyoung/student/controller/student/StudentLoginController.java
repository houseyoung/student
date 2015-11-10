package com.houseyoung.student.controller.student;

import com.houseyoung.student.dto.HealthDto;
import com.houseyoung.student.dto.ScoreDto;
import com.houseyoung.student.dto.StudentDto;
import com.houseyoung.student.entity.Course;
import com.houseyoung.student.service.CourseService;
import com.houseyoung.student.service.StudentService;
import com.houseyoung.student.service.HealthService;
import com.houseyoung.student.service.ScoreService;
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
@RequestMapping(value = "student")
public class StudentLoginController {
    @Resource
    private StudentService studentService;

    @Resource
    private ScoreService scoreService;

    @Resource
    private HealthService healthService;

    @Resource
    private CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("studentDto") != null) {
                return "redirect:student/index";
            } else {
                return "student/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/login/login";
        }
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("studentDto") != null) {
                return "redirect:index";
            } else {
                return "student/login/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/login/login";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(StudentDto studentDto, Model model, HttpServletRequest request) throws Exception{
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

    //首页
    @RequestMapping(value = "index")
    public String toIndex(Model model) throws Exception{
        try {
            return "student/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/index";
        }
    }
//
//    //修改密码
//    @RequestMapping(value = "editpassword", method = RequestMethod.GET)
//    public String toEditPassword(Model model) throws Exception{
//        try {
//            return "user/editpassword";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "user/index";
//        }
//    }
//
//    @RequestMapping(value = "editpassword", method = RequestMethod.POST)
//    public String editPassword(StudentDto studentDto, String password, Model model) throws Exception{
//        try {
//            studentDto.setStudentId(studentId);
//            studentService.editPassword(studentDto, password);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "user/editpassword";
//        }
//    }
//
//    //修改兴趣
//    @RequestMapping(value = "editinterest", method = RequestMethod.GET)
//    public String toEditInterest(Model model) throws Exception{
//        try {
//            return "user/editinterest";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "user/index";
//        }
//    }
//
//    @RequestMapping(value = "editinterest", method = RequestMethod.POST)
//    public String editInterest(StudentDto studentDto, String interest, Model model) throws Exception{
//        try {
//            studentDto.setStudentId(studentId);
//            studentService.editInterest(studentDto, interest);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "user/editinterest";
//        }
//    }
//
//    //登出
//    @RequestMapping(value = {"logoff"}, method = RequestMethod.GET)
//    public String logoff(HttpServletRequest request, Model model) throws Exception{
//        try {
//            request.getSession().removeAttribute("studentDto");
//            //清除记录的学号
//            studentId = null;
//            return "index";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "index";
//        }
//    }
//
//    //成绩页
//    @RequestMapping(value = "score")
//    public String toScore(Model model) throws Exception{
//        try {
//            List<ScoreDto> listHimself = scoreService.listHimself(studentId);
//            model.addAttribute("listHimself", listHimself);
//            return "user/score";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "user/list";
//        }
//    }
//
//    //健康页
//    @RequestMapping(value = "health")
//    public String toHealth(Model model) throws Exception{
//        try {
//            List<HealthDto> listHimself = healthService.listHimself(studentId);
//            model.addAttribute("listHimself", listHimself);
//            return "user/health";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "user/list";
//        }
//    }
//
//    //课程页
//    @RequestMapping(value = "course")
//    public String toCourse(Model model) throws Exception{
//        try {
//            List<Course> listHimself = courseService.listHimself(studentId);
//            model.addAttribute("listHimself", listHimself);
//            return "user/course";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "user/list";
//        }
//    }
}