//package com.houseyoung.student.controller;
//
//import com.houseyoung.student.dto.HealthDto;
//import com.houseyoung.student.service.AdminService;
//import com.houseyoung.student.service.HealthService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * Created by houseyoung on 15/10/11 23:14.
// */
//@Controller
//@RequestMapping(value = "admin/health")
//public class HealthController {
//    @Resource
//    private HealthService healthService;
//
//    @Resource
//    private AdminService adminService;
//
//    //显示、搜索
//    @RequestMapping(value = "")
//    public String toList(String keywords, Model model, HttpServletRequest request) throws Exception{
//        try {
//            //通过Session获取Username，再通过Username获取ClassID
//            String username = (String) request.getSession().getAttribute("instructor");
//            int classId = 0;
//            if (username != null) {
//                classId = adminService.getClassIdByUsername(username);
//            }
//
//            List<HealthDto> listHealth = healthService.listHealth(classId, keywords);
//            model.addAttribute("listHealth", listHealth);
//            return "admin/health/list";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/health/list";
//        }
//    }
//
//    //增加
//    @RequestMapping(value = "insert", method = RequestMethod.GET)
//    public String toInsert(Model model) throws Exception{
//        try {
//            return "admin/health/insert";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/health/list";
//        }
//    }
//
//    @RequestMapping(value = "insert", method = RequestMethod.POST)
//    public String insert(HealthDto healthDto, Model model) throws Exception{
//        try {
//            healthService.insert(healthDto);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/health/insert";
//        }
//    }
//
//    //删除
//    @RequestMapping(value = "delete", method = RequestMethod.GET)
//    public String toDelete(Integer id, Model model) throws Exception{
//        try {
//            healthService.delete(id);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/health/list";
//        }
//    }
//
//    //修改
//    @RequestMapping(value = "edit", method = RequestMethod.GET)
//    public String toEdit(Integer id, Model model) throws Exception{
//        try {
//            HealthDto healthDto = healthService.queryById(id);
//            model.addAttribute("healthDto", healthDto);
//            return "admin/health/edit";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/health/list";
//        }
//    }
//
//    @RequestMapping(value = "edit", method = RequestMethod.POST)
//    public String edit(HealthDto healthDto, Model model) throws Exception{
//        try {
//            healthService.update(healthDto);
//            return "redirect:";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "admin/health/edit";
//        }
//    }
//}
