package com.nhnacademy.service;

import com.nhnacademy.domain.Course;

import java.util.List;

public interface CourserService {

    List<Course> getAllCourse();

    void registerCourse(long teacherId, long subjectId);

    void modifyCourse(long id, long teacherId, long subjectId);

    void deleteCourse(long id);
}
