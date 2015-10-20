package com.myframework.controller;

import com.myframework.dto.ClassDto;
import com.myframework.service.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 8:48.
 */
@Controller
@RequestMapping(value = "/admin/class")
public class ClassController {
    @Resource
    private ClassService classService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model){
        List<ClassDto> listClass = classService.listClass(keywords);
        model.addAttribute("listClass", listClass);
        return "admin/class/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(){
        return "admin/class/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(ClassDto classDto){
        classService.insert(classDto);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        classService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model){
        ClassDto classDto = classService.queryById(id);
        model.addAttribute("classDto", classDto);
        return "admin/class/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ClassDto classDto){
        classService.update(classDto);
        return "redirect:";
    }
}
