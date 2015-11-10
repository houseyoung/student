//package com.houseyoung.student.controller;
//
//import com.houseyoung.student.dto.StudentDto;
//import com.houseyoung.student.service.AdminService;
//import com.houseyoung.student.service.StudentService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * Created by houseyoung on 15/10/8 20:52.
// */
//@Controller
//@RequestMapping(value = "admin/student")
//public class StudentController {
//    @Resource
//    private StudentService studentService;
//
//    @Resource
//    private AdminService adminService;
//
//    //显示、搜索
//    @RequestMapping(value = "")
//    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
//        try {
//            //通过Session获取Username，再通过Username获取ClassID
//            String username = (String) request.getSession().getAttribute("instructor");
//            int classId = 0;
//            if (username != null) {
//                classId = adminService.getClassIdByUsername(username);
//            }
//
//            List<StudentDto> listStudent = studentService.listStudent(classId, keywords);
//            model.addAttribute("listStudent", listStudent);
//            return "admin/student/list";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/student/list";
//        }
//    }
//
//    //增加
//    @RequestMapping(value = "insert", method = RequestMethod.GET)
//    public String toInsert(Model model) throws Exception{
//        try {
//            return "admin/student/insert";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/student/list";
//        }
//    }
//
//    @RequestMapping(value = "insert", method = RequestMethod.POST)
//    public String insert(StudentDto studentDto, Model model) throws Exception{
//        try {
//            studentService.insert(studentDto);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/student/insert";
//        }
//    }
//
//    //删除
//    @RequestMapping(value = "delete", method = RequestMethod.GET)
//    public String toDelete(Integer id, Model model) throws Exception{
//        try {
//            studentService.delete(id);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/student/list";
//        }
//    }
//
//    //修改
//    @RequestMapping(value = "edit", method = RequestMethod.GET)
//    public String toEdit(Integer id, Model model) throws Exception{
//        try {
//            StudentDto studentDto = studentService.queryById(id);
//            model.addAttribute("studentDto", studentDto);
//            return "admin/student/edit";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/student/list";
//        }
//    }
//
//    @RequestMapping(value = "edit", method = RequestMethod.POST)
//    public String edit(StudentDto studentDto, Model model) throws Exception{
//        try {
//            studentService.update(studentDto);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/student/list";
//        }
//    }
//}