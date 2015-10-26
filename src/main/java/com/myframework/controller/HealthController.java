package com.myframework.controller;

import com.myframework.dto.HealthDto;
import com.myframework.service.AdminService;
import com.myframework.service.HealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/10/11 23:14.
 */
@Controller
@RequestMapping(value = "admin/health")
public class HealthController {
    @Resource
    private HealthService healthService;

    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model, HttpServletRequest request){
        //通过Session获取Username，再通过Username获取ClassID
        String username = (String)request.getSession().getAttribute("instructor");
        int classId = adminService.getClassIdByUsername(username);

        List<HealthDto> listHealth = healthService.listHealth(classId, keywords);
        model.addAttribute("listHealth", listHealth);
        return "admin/health/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(){
        return "admin/health/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(HealthDto healthDto){
        healthService.insert(healthDto);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        healthService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model){
        HealthDto healthDto = healthService.queryById(id);
        model.addAttribute("healthDto", healthDto);
        return "admin/health/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HealthDto healthDto){
        healthService.update(healthDto);
        return "redirect:";
    }
}
