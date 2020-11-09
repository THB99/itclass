package com.thb.mapper;

import com.thb.domain.Lesson;
import com.thb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper()
public interface LessonMapper {

    public List<Lesson>  findAll();

    Lesson findLessonByid(int id);

    List<Lesson> findmylesson(int uid);

    List<Lesson> findAlllesson();

    void addLesson(Lesson lesson);
}

