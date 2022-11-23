package com.nhnacademy.repository;

import com.nhnacademy.domain.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();

    void register(long subjectId, long teacherId);

    void modify(long id, long subjectId, long teacherId);

    void delete(long id);

}
