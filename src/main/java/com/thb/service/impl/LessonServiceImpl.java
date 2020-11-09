package com.thb.service.impl;

import com.thb.domain.Lesson;
import com.thb.domain.Teacher;
import com.thb.domain.User;
import com.thb.mapper.LessonMapper;
import com.thb.mapper.TeacherMapper;
import com.thb.mapper.UserMapper;
import com.thb.service.ILessonService;
import com.thb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements ILessonService {

    @Autowired
    private LessonMapper lessonMapper;


    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Lesson>  findAll() {
        return lessonMapper.findAll();
    }

    @Override
    public Lesson findInfo(int id) {
        Lesson lesson = lessonMapper.findLessonByid(id);
        Teacher teacher = teacherMapper.findById(lesson.getTid());
        lesson.setTinfo(teacher.getInfo());
        lesson.setTname(teacher.getName());
        return lesson;
    }

    @Override
    public List<Lesson> findmylesson(int uid) {
        return lessonMapper.findmylesson(uid);
    }

    @Override
    public void addLesson(Lesson lesson) {
        lessonMapper.addLesson(lesson);
    }

}
