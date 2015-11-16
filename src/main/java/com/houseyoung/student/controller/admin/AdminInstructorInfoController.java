package com.houseyoung.student.controller.admin;

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
 * AdminInstructorInfoController
 *
 * @author: yangch
 * @time: 2015/11/12 14:59
 */
@Controller
@RequestMapping(value = "admin/instructor_info")
public class AdminInstructorInfoController {
    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = {"", "list"})
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            //管理员的ClassID=0
            List<AdminDto> listInstructor = adminService.listInstructor(0, keywords);
            model.addAttribute("listInstructor", listInstructor);
            return "admin/instructor_info/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor_info/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            return "admin/instructor_info/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor_info/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(AdminDto adminDto, Model model) throws Exception{
        try {
            adminService.insertInstructor(adminDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor_info/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            adminService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor_info/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            AdminDto adminDto = adminService.queryInstructorById(id);
            model.addAttribute("adminDto", adminDto);
            return "admin/instructor_info/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor_info/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(AdminDto adminDto, Model model) throws Exception{
        try {
            adminService.updateInstructor(adminDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/instructor_info/edit";
        }
    }
}
