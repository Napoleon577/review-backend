package com.example.demo1.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    private final String domainUrl = "http://47.115.173.133/review-backend/uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }
        try {
            // 生成唯一的文件名
            String originalFilename = file.getOriginalFilename();
            String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFilename;
            // 定义本地文件夹路径
            String localDir = System.getProperty("user.dir") + "/uploads/";
            // 检查目录是否存在，如果不存在则创建
            File directory = new File(localDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // 定义保存文件的完整路径
            String savePath = localDir + uniqueFileName;
            // 保存文件
            file.transferTo(new File(savePath));
            // 构建本地文件的URL
            String fileUrl = domainUrl + uniqueFileName;
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败");
        }
    }
}