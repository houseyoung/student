package com.houseyoung.student.controller.student;

import com.houseyoung.student.dto.HealthDto;
import com.houseyoung.student.dto.ScoreDto;
import com.houseyoung.student.dto.StudentDto;
import com.houseyoung.student.entity.Course;
import com.houseyoung.student.service.CourseService;
import com.houseyoung.student.service.HealthService;
import com.houseyoung.student.service.ScoreService;
import com.houseyoung.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * StudentInfoController
 *
 * @author: yangch
 * @time: 2015/11/10 17:49
 */
@Controller
@RequestMapping(value = "student/student_info")
public class StudentInfoController {
    @Resource
    private StudentService studentService;

    @Resource
    private HealthService healthService;

    @Resource
    private CourseService courseService;

    @Resource
    private ScoreService scoreService;

    //去个人信息页
    @RequestMapping(value = {"", "list"})
    public String toIndex(Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取StudentID
            String studentId = (String) request.getSession().getAttribute("studentDto");
            StudentDto showHimself = studentService.showHimself(studentId);

            //显示右上角个人信息
            model.addAttribute("studentName", showHimself.getStudentName());
            model.addAttribute("studentId", studentId);

            model.addAttribute("showHimself", showHimself);

            List<HealthDto> listHimselfHealth = healthService.listHimself(studentId);
            model.addAttribute("listHimselfHealth", listHimselfHealth);
            return "student/student_info/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/student_info/list";
        }
    }

    //去修改兴趣页
    @RequestMapping(value = "editinterest", method = RequestMethod.GET)
    public String toEditInterest(Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取StudentID
            String studentId = (String) request.getSession().getAttribute("studentDto");
            StudentDto showHimself = studentService.showHimself(studentId);

            //显示右上角个人信息
            model.addAttribute("studentName", showHimself.getStudentName());
            model.addAttribute("studentId", studentId);

            model.addAttribute("interest", showHimself.getInterest());
            return "student/student_info/editinterest";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/student_info/list";
        }
    }

    @RequestMapping(value = "editinterest", method = RequestMethod.POST)
    public String editInterest(StudentDto studentDto, String interest, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取StudentID
            String studentId = (String) request.getSession().getAttribute("studentDto");
            //显示右上角个人信息
            model.addAttribute("studentName", studentService.showHimself(studentId).getStudentName());
            model.addAttribute("studentId", studentId);

            studentDto.setStudentId(studentId);
            studentService.editInterest(studentDto, interest);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/student_info/editinterest";
        }
    }

    //去修改个人信息页
    @RequestMapping(value = "edithimself", method = RequestMethod.GET)
    public String toEditPassword(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String studentId = (String) request.getSession().getAttribute("studentDto");
            model.addAttribute("studentName", studentService.showHimself(studentId).getStudentName());
            model.addAttribute("studentId", studentId);

            return "student/student_info/edithimself";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/student_info/list";
        }
    }

    @RequestMapping(value = "edithimself", method = RequestMethod.POST)
    public String editPassword(StudentDto studentDto, String password, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取StudentID
            String studentId = (String) request.getSession().getAttribute("studentDto");
            //显示右上角个人信息
            model.addAttribute("studentName", studentService.showHimself(studentId).getStudentName());
            model.addAttribute("studentId", studentId);

            studentDto.setStudentId(studentId);
            studentService.editPassword(studentDto, password);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/edithimself/list";
        }
    }

    //去课程页
    @RequestMapping(value = "course")
    public String toCourse(Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取StudentID
            String studentId = (String) request.getSession().getAttribute("studentDto");
            //显示右上角个人信息
            model.addAttribute("studentName", studentService.showHimself(studentId).getStudentName());
            model.addAttribute("studentId", studentId);

            List<Course> listHimself = courseService.listHimself(studentId);
            model.addAttribute("listHimself", listHimself);
            return "student/student_info/course";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/student_info/list";
        }
    }

    //去成绩页
    @RequestMapping(value = "score")
    public String toScore(Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取StudentID
            String studentId = (String) request.getSession().getAttribute("studentDto");
            //显示右上角个人信息
            model.addAttribute("studentName", studentService.showHimself(studentId).getStudentName());
            model.addAttribute("studentId", studentId);

            List<ScoreDto> listHimself = scoreService.listHimself(studentId);
            model.addAttribute("listHimself", listHimself);
            return "student/student_info/score";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/student_info/list";
        }
    }
}
