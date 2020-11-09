package com.thb.service;

import com.thb.domain.Lesson;
import com.thb.domain.User;

import java.util.List;

public interface ILessonService {
    public List<Lesson> findAll();

    Lesson findInfo(int id);

    List<Lesson> findmylesson(int uid);

    void addLesson(Lesson lesson);
}
