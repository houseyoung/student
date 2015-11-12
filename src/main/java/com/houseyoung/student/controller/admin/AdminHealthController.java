package com.houseyoung.student.controller.admin;

import com.houseyoung.student.dto.HealthDto;
import com.houseyoung.student.service.AdminService;
import com.houseyoung.student.service.HealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * AdminHealthController
 *
 * @author: yangch
 * @time: 2015/11/12 14:37
 */
@Controller
@RequestMapping(value = "admin/health")
public class AdminHealthController {
    @Resource
    private HealthService healthService;

    //显示、搜索
    @RequestMapping(value = {"", "list"})
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            //管理员的ClassID=0
            List<HealthDto> listHealth = healthService.listHealth(0, keywords);
            model.addAttribute("listHealth", listHealth);
            return "admin/health/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/health/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            return "admin/health/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/health/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(HealthDto healthDto, Model model) throws Exception{
        try {
            healthService.insert(healthDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/health/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            healthService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/health/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            HealthDto healthDto = healthService.queryById(id);
            model.addAttribute("healthDto", healthDto);
            return "admin/health/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/health/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HealthDto healthDto, Model model) throws Exception{
        try {
            healthService.update(healthDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/health/edit";
        }
    }
}
