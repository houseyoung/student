package com.houseyoung.student.controller;

import com.houseyoung.student.dto.ClassDto;
import com.houseyoung.student.service.ClassService;
import com.houseyoung.student.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 8:48.
 */
@Controller
@RequestMapping(value = "/admin/class")
public class ClassController {
    @Resource
    private ClassService classService;

    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ClassID
            String username = (String) request.getSession().getAttribute("instructor");
            int classId = 0;
            if (username != null) {
                classId = adminService.getClassIdByUsername(username);
            }

            List<ClassDto> listClass = classService.listClass(classId, keywords);
            model.addAttribute("listClass", listClass);
            return "admin/class/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/class/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) throws Exception{
        try {
            return "admin/class/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/class/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(ClassDto classDto, Model model) throws Exception{
        try {
            classService.insert(classDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/class/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            classService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/class/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model) throws Exception {
        try {
            ClassDto classDto = classService.queryById(id);
            model.addAttribute("classDto", classDto);
            return "admin/class/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/class/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ClassDto classDto, Model model) throws Exception{
        try {
            classService.update(classDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/class/edit";
        }
    }
}
