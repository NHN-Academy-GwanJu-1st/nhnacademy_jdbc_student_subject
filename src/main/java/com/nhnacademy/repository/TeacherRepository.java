package com.nhnacademy.repository;

import com.nhnacademy.domain.Teacher;

import java.util.List;

public interface TeacherRepository {
    Teacher findById(long id);

    List<Teacher> findAll();
}
