package com.manulife.springbatch.controller;

import com.manulife.springbatch.tool.FileHandleUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping("/file")
@RestController
public class ReadFileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(file==null)
        {
            return "上传文件不能为空!!";
        }
        //图片访问地址 http://localhost:8080/upload/image/timg%20(2).jpg
        return "文件存放路径为" + FileHandleUtil.upload(file.getInputStream(), "image/", file.getOriginalFilename());
    }

    @PostMapping("/getUpload")
    public String upload(MultipartHttpServletRequest request) throws IOException {
        //相当于获取form表单隐藏域的参数
        String  resourceId  =  request.getParameter("resource_id");
        //获取form表单要上传的文件
        MultipartFile  file  =  request.getFile("file");
        FileHandleUtil.upload(file.getInputStream(), "image/", file.getOriginalFilename());
        return resourceId+"success";
    }

    @RequestMapping(value = "/getImage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() throws IOException {
        InputStream inputStream = FileHandleUtil.getImage("image/timg (2).jpg");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;

    }

    @PostMapping("/modifyJpg")
    public String modifyJpg() throws IOException {
        File file = new File(FileHandleUtil.getPath()+"image");
        File[] tempList = file.listFiles();
        for(File mfile:tempList)
        {
            mfile.renameTo(new File(mfile.getParent()+File.separator+mfile.getName().replaceAll("\\s","").trim().toUpperCase()));
        }
        return "success!!";
    }

}
