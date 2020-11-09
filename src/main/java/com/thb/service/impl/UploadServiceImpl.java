package com.thb.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.thb.service.IUploadService;
import com.thb.utils.TencentUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class UploadServiceImpl implements IUploadService {
    @Override
    public Map<String, String> uploadFileInTencent(MultipartFile image) {
        COSClient cosClient = TencentUtil.TencentStart();//工具类
        String originalFilename = image.getOriginalFilename();
//        String extName = StringUtils.substringAfterLast(originalFilename, ".");//获取后缀名
        String bucketName = "itclass-1300650300";
        // 指定要上传到 COS 上对象键
//        String key = UUID.randomUUID().toString() + System.nanoTime() + "." + extName;//为接收到的文件命名
        String key=originalFilename;
        InputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(image.getSize());
        PutObjectRequest putObjectRequest =
                new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        cosClient.generatePresignedUrl(bucketName, key, expiration);
        Map<String, String> urlMap = new HashMap<>();
        urlMap.put("url","https://itclass-1300650300.cos.ap-nanjing.myqcloud.com/"+key);
        urlMap.put("key",key);
        return urlMap;
    }


    public String uploadFileInTencent2(MultipartFile image) {
        COSClient cosClient = TencentUtil.TencentStart();//工具类
        String originalFilename = image.getOriginalFilename();
        String extName = StringUtils.substringAfterLast(originalFilename, ".");//获取后缀名
        String bucketName = "itclass-1300650300";
        // 指定要上传到 COS 上对象键
        String key = UUID.randomUUID().toString() + System.nanoTime() + "." + extName;//为接收到的文件命名
//        String key=originalFilename;
        InputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(image.getSize());
        PutObjectRequest putObjectRequest =
                new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        cosClient.generatePresignedUrl(bucketName, key, expiration);
        return "https://itclass-1300650300.cos.ap-nanjing.myqcloud.com/"+key;
    }
}
