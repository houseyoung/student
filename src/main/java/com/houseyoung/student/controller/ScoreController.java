package com.houseyoung.student.controller;

import com.houseyoung.student.dto.ScoreDto;
import com.houseyoung.student.service.ScoreService;
import com.houseyoung.student.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:59.
 */
@Controller
@RequestMapping(value = "admin/score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String studentId, String courseName, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ClassID
            String username = (String) request.getSession().getAttribute("instructor");
            int classId = 0;
            if (username != null) {
                classId = adminService.getClassIdByUsername(username);
            }

            List<ScoreDto> listScore = scoreService.listScore(classId, studentId, courseName);
            model.addAttribute("listScore", listScore);
            return "admin/score/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/score/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) throws Exception{
        try {
            return "admin/score/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/score/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(ScoreDto scoreDto, Model model) throws Exception{
        try {
            scoreService.insert(scoreDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/score/insert";
        }
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id, Model model) throws Exception{
        try {
            scoreService.delete(id);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/score/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model) throws Exception{
        try {
            ScoreDto scoreDto = scoreService.queryById(id);
            model.addAttribute("scoreDto", scoreDto);
            return "admin/score/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/score/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ScoreDto scoreDto, Model model) throws Exception{
        try {
            scoreService.update(scoreDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/score/edit";
        }
    }
}
