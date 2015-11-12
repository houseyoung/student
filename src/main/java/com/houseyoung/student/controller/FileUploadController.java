package com.houseyoung.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by houseyoung on 2015/9/28 17:09.
 * 文件上传Controller
 */
@RequestMapping(value = "")
@Controller
public class FileUploadController {
    //通用文件上传功能
    @RequestMapping(value = "fileupload")
    public String upload(@RequestParam(value = "file", required = false)  MultipartFile file, HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("resources/upload");
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path, fileName);
        //若目录不存在则创建之
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回文件地址
        model.addAttribute("fileUrl", request.getContextPath() + "/resources/upload/" + fileName);
        //返回文件名
        model.addAttribute("fileName", fileName);

        return "upload";
    }

    //上传管理员头像
    @RequestMapping(value = "uploadicon_admin")
    public String adminUploadPic(@RequestParam(value = "file", required = false)  MultipartFile file, HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("resources/upload/pic/admin");
        //获取Username
        String username = (String) request.getSession().getAttribute("admin");

        String fileName = username + ".png";
        File targetFile = new File(path, fileName);
        //若目录不存在则创建之
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "upload";
    }

    //上传辅导员头像
    @RequestMapping(value = "uploadicon_instructor")
    public String instructorUploadPic(@RequestParam(value = "file", required = false)  MultipartFile file, HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("resources/upload/pic/instructor");
        //获取Username
        String username = (String) request.getSession().getAttribute("instructor");

        String fileName = username + ".png";
        File targetFile = new File(path, fileName);
        //若目录不存在则创建之
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "upload";
    }

    //上传学生头像
    @RequestMapping(value = "uploadicon_student")
    public String studentUploadPic(@RequestParam(value = "file", required = false)  MultipartFile file, HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("resources/upload/pic/student");
        //获取Username
        String username = (String) request.getSession().getAttribute("studentDto");

        String fileName = username + ".png";
        File targetFile = new File(path, fileName);
        //若目录不存在则创建之
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "upload";
    }

    //显示上传页
    @RequestMapping(value = "upload")
    public String toFileUpload(){
        return "upload";
    }
}