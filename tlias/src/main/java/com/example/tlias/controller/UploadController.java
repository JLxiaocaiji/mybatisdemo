package com.example.tlias.controller;

import com.example.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, @RequestParam MultipartFile image) throws Exception {
        log.info("文件上传:{},{},{}", username, age, image);

        // 获取文件原始名
        String originalFilename = image.getOriginalFilename();

        // 构造唯一文件名---uuid
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新文件名: {}", newFileName);

        // 将接收到的文件转存到服务器某个磁盘文件
        image.transferTo( new File("D:\\niii_code\\java_backend\\images" + newFileName));
        return Result.success();
    }
}
