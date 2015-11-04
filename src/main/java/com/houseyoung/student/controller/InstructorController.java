package com.houseyoung.student.controller;

import com.houseyoung.student.dto.AdminDto;
import com.houseyoung.student.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/10/25 22:36.
 */
@Controller
@RequestMapping(value = "admin")
public class InstructorController {
    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = {"instructor", "instructor/"})
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ClassID
            String username = (String) request.getSession().getAttribute("instructor");
            int classId = 0;
            if (username != null) {
                classId = adminService.getClassIdByUsername(username);
            }

            List<AdminDto> listInstructor = adminService.listInstructor(classId, keywords);
            model.addAttribute("listInstructor", listInstructor);
            return "admin/instructor/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor/list";
        }
    }

    //增加
    @RequestMapping(value = "instructor/insert", method = RequestMethod.GET)
    public String toInsert(Model model) throws Exception{
        try {
            return "admin/instructor/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor/list";
        }
    }

    @RequestMapping(value = "instructor/insert", method = RequestMethod.POST)
    public String insert(AdminDto adminDto, Model model) throws Exception{
        try {
            adminService.insertInstructor(adminDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor/insert";
        }
    }

    //删除
    @RequestMapping(value = "instructor/delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            adminService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor/list";
        }
    }

    //修改
    @RequestMapping(value = "instructor/edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model) throws Exception{
        try {
            AdminDto adminDto = adminService.queryInstructorById(id);
            model.addAttribute("adminDto", adminDto);
            return "admin/instructor/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor/list";
        }
    }

    @RequestMapping(value = "instructor/edit", method = RequestMethod.POST)
    public String edit(AdminDto adminDto, Model model) throws Exception{
        try {
            adminService.updateInstructor(adminDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor/edit";
        }
    }
}
