package com.thb.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface IUploadService {
    public Map<String, String> uploadFileInTencent(MultipartFile image);

    public String uploadFileInTencent2(MultipartFile image);
}
