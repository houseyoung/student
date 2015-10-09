package com.myframework.controller;

import com.myframework.dto.DepartmentDto;
import com.myframework.service.DepartmentService;
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
@RequestMapping(value = "department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model){
        List<DepartmentDto> listDepartment = departmentService.listDepartment(keywords);
        model.addAttribute("listDepartment", listDepartment);
        return "department/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(){
        return "department/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(DepartmentDto departmentDto){
        departmentService.insert(departmentDto);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        departmentService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model){
        DepartmentDto departmentDto = departmentService.queryById(id);
        model.addAttribute("departmentDto", departmentDto);
        return "department/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(DepartmentDto departmentDto){
        departmentService.update(departmentDto);
        return "redirect:";
    }
}
