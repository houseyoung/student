package com.houseyoung.student.controller.instructor;

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
 * Created by houseyoung on 15/11/15 17:08.
 */
@Controller
@RequestMapping(value = "instructor/course")
public class InstructorCourseController {

    @Resource
    private CourseService courseService;

    //显示、搜索
    @RequestMapping(value = {"", "list"})
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("instructor");
            model.addAttribute("username", username);

            List<Course> listCourse = courseService.listCourse(keywords);
            model.addAttribute("listCourse", listCourse);
            return "instructor/course/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/course/list";
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
            return "instructor/course/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("instructor");
            model.addAttribute("username", username);

            Course course = courseService.queryById(id);
            model.addAttribute("course", course);
            return "instructor/course/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/course/list";
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
