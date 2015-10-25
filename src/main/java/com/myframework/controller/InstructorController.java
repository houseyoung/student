package com.myframework.controller;

import com.myframework.dto.AdminDto;
import com.myframework.entity.Admin;
import com.myframework.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houseyoung on 15/10/25 22:36.
 */
@Controller
@RequestMapping(value = "admin/instructor")
public class InstructorController {
    @Resource
    private AdminService adminService;

    //记录登录的ID
    private int id = 0;
    //记录登录者的ClassID
    private int classId = 0;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model){
        List<AdminDto> listInstructor = adminService.listInstructor(keywords, id, classId);
        model.addAttribute("listInstructor", listInstructor);
        return "admin/instructor/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(){
        return "admin/instructor/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(AdminDto adminDto){
        adminService.insertInstructor(adminDto);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        adminService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model){
        AdminDto adminDto = adminService.queryInstructorById(id);
        model.addAttribute("adminDto", adminDto);
        return "admin/instructor/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(AdminDto adminDto){
        adminService.updateInstructor(adminDto);
        return "redirect:";
    }
}
