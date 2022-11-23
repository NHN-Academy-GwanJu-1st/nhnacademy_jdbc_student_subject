package com.nhnacademy.service;

import com.nhnacademy.domain.Teacher;
import com.nhnacademy.repository.TeacherRepository;

import java.util.List;

public interface TeacherService {

    Teacher getTeacher(long id);

    List<Teacher> getAllTeacher();

}
