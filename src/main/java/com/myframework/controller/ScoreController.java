package com.myframework.controller;

import com.myframework.dto.ScoreDto;
import com.myframework.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:59.
 */
@Controller
@RequestMapping(value = "admin/score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    //显示、搜索
    @RequestMapping(value = "")
    public String toList(String keywords, Model model){
        List<ScoreDto> listScore = scoreService.listScore(keywords);
        model.addAttribute("listScore", listScore);
        return "admin/score/list";
    }

    //增加
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(){
        return "admin/score/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(ScoreDto scoreDto){
        scoreService.insert(scoreDto);
        return "redirect:";
    }

    //删除
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String toDelete(Integer id){
        scoreService.delete(id);
        return "redirect:";
    }

    //修改
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String toEdit(Integer id, Model model){
        ScoreDto scoreDto = scoreService.queryById(id);
        model.addAttribute("scoreDto", scoreDto);
        return "admin/score/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(ScoreDto scoreDto){
        scoreService.update(scoreDto);
        return "redirect:";
    }
}
