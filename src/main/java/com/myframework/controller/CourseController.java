package com.myframework.controller;

import com.myframework.entity.Course;
import com.myframework.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 14:52.
 */
@Controller
@RequestMapping(value = "admin/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model){
        List<Course> listCourse = courseService.listCourse(keywords);
        model.addAttribute("listCourse", listCourse);
        return "admin/course/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(){
        return "admin/course/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Course course){
        courseService.insert(course);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        courseService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model){
        Course course = courseService.queryById(id);
        model.addAttribute("course", course);
        return "admin/course/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(Course course){
        courseService.update(course);
        return "redirect:";
    }
}
