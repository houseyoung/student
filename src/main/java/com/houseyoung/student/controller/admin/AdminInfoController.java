package com.houseyoung.student.controller.admin;

import com.houseyoung.student.dto.AdminDto;
import com.houseyoung.student.entity.Admin;
import com.houseyoung.student.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * AdminInfoController
 *
 * @author: yangch
 * @time: 2015/11/12 15:20
 */
@Controller
@RequestMapping(value = "admin/admin_info")
public class AdminInfoController {
    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = {"", "list"})
    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ID
            String username = (String) request.getSession().getAttribute("admin");
            int id = 0;
            if (username != null) {
                id = adminService.getIdByUsername(username);
            }

            //显示右上角个人信息
            model.addAttribute("username", username);

            //输出登录人ID至前端
            model.addAttribute("id", id);

            //显示除自己外其他人的信息
            List<Admin> listAdmin = adminService.listAdmin(keywords, id);
            model.addAttribute("listAdmin", listAdmin);

            //显示自己的信息
            Admin showHimself = adminService.showHimself(id);
            model.addAttribute("showHimself", showHimself);

            return "admin/admin_info/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/admin_info/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("admin");
            model.addAttribute("username", username);

            return "admin/admin_info/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/admin_info/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Admin admin, Model model) throws Exception{
        try {
            adminService.insertAdmin(admin);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/admin_info/insert";
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
            return "admin/admin_info/list";
        }
    }

    //修改个人信息
    @RequestMapping(value = "edithimself", method = RequestMethod.GET)
    public String toEditHimself(Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ID
            String username = (String) request.getSession().getAttribute("admin");
            int id = 0;
            if (username != null) {
                id = adminService.getIdByUsername(username);
            }

            //显示右上角个人信息
            model.addAttribute("username", username);

            //显示原有信息
            Admin showHimself = adminService.showHimself(id);
            model.addAttribute("showHimself", showHimself);
            return "admin/admin_info/edithimself";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/admin_info/list";
        }
    }

    @RequestMapping(value = "edithimself", method = RequestMethod.POST)
    public String editHimself(Admin admin, String username, String password, String name, Model model) throws Exception{
        try {
            int id = 0;
            if (username != null) {
                id = adminService.getIdByUsername(username);
            }

            //显示右上角个人信息
            model.addAttribute("username", username);

            admin.setId(id);
            adminService.editHimself(admin, username, password, name);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/admin_info/edithimself";
        }
    }
}
