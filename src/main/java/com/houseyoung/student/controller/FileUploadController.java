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
    @RequestMapping(value = "fileUpload")
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

    @RequestMapping(value = "upload")
    public String toFileUpload(){
        return "upload";
    }
}