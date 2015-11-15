package com.houseyoung.student.controller.instructor;

import com.houseyoung.student.dto.ScoreDto;
import com.houseyoung.student.service.AdminService;
import com.houseyoung.student.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by houseyoung on 15/11/15 17:41.
 */
@Controller
@RequestMapping(value = "instructor/score")
public class InstructorScoreController {
    @Resource
    private ScoreService scoreService;

    @Resource
    private AdminService adminService;

    //显示、搜索
    @RequestMapping(value = {"", "list"})
    public String toList(String studentId, String courseName, Model model, HttpServletRequest request) throws Exception{
        try {
            //通过Session获取Username，再通过Username获取ClassID
            String username = (String) request.getSession().getAttribute("instructor");
            int classId = 0;
            if (username != null) {
                classId = adminService.getClassIdByUsername(username);
            }

            //显示右上角个人信息
            model.addAttribute("username", username);

            List<ScoreDto> listScore = scoreService.listScore(classId, studentId, courseName);
            model.addAttribute("listScore", listScore);
            return "instructor/score/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/score/list";
        }
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("instructor");
            model.addAttribute("username", username);

            return "instructor/score/insert";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/score/list";
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(ScoreDto scoreDto, Model model) throws Exception{
        try {
            scoreService.insert(scoreDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/score/insert";
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
            return "instructor/score/list";
        }
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model, HttpServletRequest request) throws Exception{
        try {
            //显示右上角个人信息
            String username = (String) request.getSession().getAttribute("instructor");
            model.addAttribute("username", username);

            ScoreDto scoreDto = scoreService.queryById(id);
            model.addAttribute("scoreDto", scoreDto);
            return "instructor/score/edit";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/score/list";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ScoreDto scoreDto, Model model) throws Exception{
        try {
            scoreService.update(scoreDto);
            return "redirect:";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "instructor/score/edit";
        }
    }
}
