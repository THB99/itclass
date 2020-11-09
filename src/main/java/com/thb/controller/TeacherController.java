package com.thb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thb.domain.Lesson;
import com.thb.domain.Teacher;
import com.thb.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("getallteacher")
    public List<Teacher> getallteacher(){
        return teacherService.findAllteacher();
    }


    @RequestMapping("getteacherlist")
    public PageInfo<Teacher> getteacherlist(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teachers = teacherService.findAllteacher();
        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(teachers);
        return pageInfo;
    }

    @RequestMapping("addteacher")
    public String addteacher(@RequestBody Teacher teacher){
        teacherService.add(teacher);
        return "ok";
    }
}
