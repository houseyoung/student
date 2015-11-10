package com.houseyoung.student.controller.admin;

import com.houseyoung.student.entity.School;
import com.houseyoung.student.service.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * AdminSchoolController
 *
 * @author: yangch
 * @time: 2015/11/10 19:13
 */
@Controller
@RequestMapping(value = "admin/school")
public class AdminSchoolController {
    @Resource
    private SchoolService schoolService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model) throws Exception{
        try {
            List<School> listSchool = schoolService.listSchool(keywords);
            model.addAttribute("listSchool", listSchool);
            return "admin/school/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/school/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) throws Exception{
        try {
            return "admin/school/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/school/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(School school, Model model) throws Exception{
        try {
            schoolService.insert(school);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/school/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            schoolService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/school/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model) throws Exception{
        try {
            School school = schoolService.queryById(id);
            model.addAttribute("school", school);
            return "admin/school/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/school/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(School school, Model model) throws Exception{
        try {
            schoolService.update(school);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/school/edit";
        }
    }
}
