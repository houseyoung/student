package com.houseyoung.student.controller.instructor;

import com.houseyoung.student.dto.ClassDto;
import com.houseyoung.student.service.AdminService;
import com.houseyoung.student.service.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/11/16 14:15.
 */
@Controller
@RequestMapping(value = "instructor/class")
public class InstructorClassController {
    @Resource
    private ClassService classService;

    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = {"", "list"})
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ClassID
            String username = (String) request.getSession().getAttribute("instructor");
            int classId = 0;
            if (username != null) {
                classId = adminService.getClassIdByUsername(username);
            }

            //显示右上角个人信息
            model.addAttribute("username", username);

            List<ClassDto> listClass = classService.listClass(classId, keywords);
            model.addAttribute("listClass", listClass);
            return "instructor/class/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/class/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model, HttpServletRequest request) throws Exception {
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("instructor");
            model.addAttribute("username", username);

            ClassDto classDto = classService.queryById(id);
            model.addAttribute("classDto", classDto);
            return "instructor/class/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/class/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ClassDto classDto, Model model) throws Exception{
        try {
            classService.update(classDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/class/edit";
        }
    }
}
