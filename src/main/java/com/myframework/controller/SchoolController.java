package com.myframework.controller;

import com.myframework.entity.School;
import com.myframework.service.SchoolService;
import com.myframework.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houseyoung on 15/10/8 21:34.
 */
@Controller
@RequestMapping(value = "school")
public class SchoolController {
    @Resource
    private SchoolService schoolService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toSchoolList(String keywords, Model model){
        List<School> listSchool = schoolService.listSchool(keywords);
        model.addAttribute("listSchool", listSchool);
        return "school/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toSchoolInsert(){
        return "school/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String schoolInsert(School school){
        schoolService.insert(school);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toSchoolDelete(Integer id){
        schoolService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toSchoolEdit(Integer id, Model model){
        School school = schoolService.queryById(id);
        model.addAttribute("school", school);
        return "school/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String SchoolEdit(School school){
        schoolService.update(school);
        return "redirect:";
    }
}
