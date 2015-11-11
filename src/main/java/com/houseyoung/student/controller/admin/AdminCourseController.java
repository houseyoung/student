package com.houseyoung.student.controller.admin;

import com.houseyoung.student.entity.Course;
import com.houseyoung.student.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * AdminCourseController
 *
 * @author: yangch
 * @time: 2015/11/11 9:27
 */
@Controller
@RequestMapping(value = "admin/course")
public class AdminCourseController {
    @Resource
    private CourseService courseService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            List<Course> listCourse = courseService.listCourse(keywords);
            model.addAttribute("listCourse", listCourse);
            return "admin/course/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/course/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            return "admin/course/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/course/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Course course, Model model) throws Exception{
        try {
            courseService.insert(course);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/course/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            courseService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/course/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            Course course = courseService.queryById(id);
            model.addAttribute("course", course);
            return "admin/course/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/course/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(Course course, Model model) throws Exception{
        try {
            courseService.update(course);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/course/edit";
        }
    }
}
