package com.houseyoung.student.controller;

import com.houseyoung.student.dto.DepartmentDto;
import com.houseyoung.student.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houseyoung on 15/10/8 22:39.
 */
@Controller
@RequestMapping(value = "admin/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model) throws Exception{
        try {
            List<DepartmentDto> listDepartment = departmentService.listDepartment(keywords);
            model.addAttribute("listDepartment", listDepartment);
            return "admin/department/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/department/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) throws Exception{
        try {
            return "admin/department/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/department/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(DepartmentDto departmentDto, Model model) throws Exception{
        try {
            departmentService.insert(departmentDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/department/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            departmentService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/department/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model) throws Exception{
        try {
            DepartmentDto departmentDto = departmentService.queryById(id);
            model.addAttribute("departmentDto", departmentDto);
            return "admin/department/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/department/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(DepartmentDto departmentDto, Model model) throws Exception{
        try {
            departmentService.update(departmentDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/department/edit";
        }
    }
}
