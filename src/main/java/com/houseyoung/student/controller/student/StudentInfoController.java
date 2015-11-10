package com.houseyoung.student.controller.student;

import com.houseyoung.student.dto.StudentDto;
import com.houseyoung.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * StudentInfoController
 *
 * @author: yangch
 * @time: 2015/11/10 17:49
 */
@Controller
@RequestMapping(value = "student")
public class StudentInfoController {
    @Resource
    private StudentService studentService;

    //个人信息页
    @RequestMapping(value = "studentinfo")
    public String toIndex(Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取StudentID
            String studentId = (String) request.getSession().getAttribute("studentDto");
            StudentDto showHimself = studentService.showHimself(studentId);
            model.addAttribute("showHimself", showHimself);
            return "student/student_info/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "student/student_info/list";
        }
    }
}
