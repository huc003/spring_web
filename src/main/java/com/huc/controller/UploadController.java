package com.huc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huc on 2017/3/1.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file){//1使用MultipartFile 接受上传文件
        try {
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.indexOf("."),fileName.length());
            FileUtils.writeByteArrayToFile(new File("e:/upload/"+ new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+suffix),file.getBytes());//2使用FileUtils.writeByteArrayToFile快速写文件到磁盘
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
