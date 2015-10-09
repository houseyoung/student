package com.myframework.controller;

import com.myframework.dto.StudentDto;
import com.myframework.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:52.
 */
@Controller
@RequestMapping(value = "student")
public class StudentController {
    @Resource
    private StudentService studentService;

    //显示、搜索
    @RequestMapping(value = {"", "/"})
    public String toList(String keywords, Model model){
        List<StudentDto> listStudent = studentService.listStudent(keywords);
        model.addAttribute("listStudent", listStudent);
        return "student/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(){
        return "student/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(StudentDto studentDto){
        studentService.insert(studentDto);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        studentService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model){
        StudentDto studentDto = studentService.queryById(id);
        model.addAttribute("studentDto", studentDto);
        return "student/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(StudentDto studentDto){
        studentService.update(studentDto);
        return "redirect:";
    }
}