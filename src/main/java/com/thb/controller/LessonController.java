package com.thb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thb.domain.Lesson;
import com.thb.mapper.LessonMapper;
import com.thb.service.ILessonService;
import com.thb.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class LessonController {

    @Autowired
    private IUploadService uploadService;
    @Autowired
    private ILessonService lessonService;

    @Autowired
    private LessonMapper lessonMapper;

    @RequestMapping(value = "/getAllLesson")
    public PageInfo<Lesson> AllLesson(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Lesson> lessons = lessonService.findAll();
        PageInfo<Lesson> pageInfo = new PageInfo<>(lessons);
        return pageInfo;
    }

//    @RequestMapping(value = "/getAllLesson")
//    public List<Lesson> AllLesson(){
////        PageHelper.startPage(pageNum,pageSize);
//        List<Lesson> lessons = lessonService.findAll();
////        PageInfo<Lesson> pageInfo = new PageInfo<>(lessons);
//        return lessons;
//    }

    @RequestMapping(value = "/getInfo")
    public Lesson getInfo(int id){
//        System.out.println(id);
        return lessonService.findInfo(id);
    }

    @RequestMapping("/getmylesson")
    public List<Lesson> getmylesson(int uid){
        return lessonService.findmylesson(uid);
    }

    @RequestMapping("/upload1")
    public String upload1(MultipartFile file) throws Exception {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
//            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            String filePath = "D:\\Github\\";
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";

//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        // 在file文件夹中创建名为fileName的文件
//        OutputStreamWriter op = new OutputStreamWriter(new FileOutputStream("D:\\Github\\" + fileName), "UTF-8");
//        // 获取文件输入流
//        InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
//        char[] bytes = new char[12];
//        // 如果这里的bytes不是数组，则每次只会读取一个字节，例如test会变成 t   e     s    t
//        while (inputStreamReader.read(bytes) != -1){
//            op.write(bytes);
//        }
//        // 关闭输出流
//        op.close();
//        // 关闭输入流
//        inputStreamReader.close();
//        return "上传成功";
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws Exception {
        Map<String, String> stringStringMap = uploadService.uploadFileInTencent(file);
        System.out.println(stringStringMap);
        return "ok";
    }

    @RequestMapping("findAllLesson")
    public PageInfo<Lesson> findAllLesson(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Lesson> lessons = lessonMapper.findAlllesson();
        PageInfo<Lesson> pageInfo = new PageInfo<Lesson>(lessons);
        return pageInfo;
    }

    @RequestMapping("/addlesson")
    public String addlesson(@RequestBody Lesson lesson){
        System.out.println(lesson+"----------");
        lessonService.addLesson(lesson);
        return "ok";
    }

    @RequestMapping("issue_upload")
    public String issueLesson1(MultipartFile file){
        String url = uploadService.uploadFileInTencent2(file);
        return url;
    }
}
