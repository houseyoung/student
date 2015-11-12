package com.houseyoung.student.controller.admin;

import com.houseyoung.student.dto.StudentDto;
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
 * AdminStudentInfoController
 *
 * @author: yangch
 * @time: 2015/11/12 14:11
 */
@Controller
@RequestMapping(value = "admin/student_info")
public class AdminStudentInfoController {
    @Resource
    private StudentService studentService;

    //显示、搜索
    @RequestMapping(value = {"", "list"})
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            //管理员的ClassID=0
            List<StudentDto> listStudent = studentService.listStudent(0, keywords);
            model.addAttribute("listStudent", listStudent);
            return "admin/student_info/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/student_info/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            return "admin/student_info/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/student_info/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(StudentDto studentDto, Model model) throws Exception{
        try {
            studentService.insert(studentDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/student_info/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            studentService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/student_info/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            StudentDto studentDto = studentService.queryById(id);
            model.addAttribute("studentDto", studentDto);
            return "admin/student_info/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/student_info/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(StudentDto studentDto, Model model) throws Exception{
        try {
            studentService.update(studentDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/student_info/list";
        }
    }
}
