package com.wn.controller;

import com.wn.pojo.Result;
import com.wn.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/5 11:11
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class uploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件：{}", file);
        if (!file.isEmpty()) {
            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + extName;
            // 上传文件
            String url = aliyunOSSOperator.upload(file.getBytes(), uniqueFileName);
            return Result.success(url);
        }
        return Result.error("上传失败");
    }


/**
 * 本地磁盘上传存储方案
 *
 * @param name
 * @param age
 * @param file
 * @return
 * @throws IOException
 */
    /*@PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {

        log.info("接收参数：{},{},{}", name, age, file);

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 新的文件名
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extension;

        // 保存文件
        file.transferTo(new File("/Users/chinhae/Desktop/im/" + newFileName));
        return Result.success();
    }*/
}
