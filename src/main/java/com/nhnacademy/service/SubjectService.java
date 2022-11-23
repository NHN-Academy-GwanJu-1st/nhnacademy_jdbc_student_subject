package com.nhnacademy.service;

import com.nhnacademy.domain.Subject;

import java.util.List;

public interface SubjectService {

    Subject getSubject(long id);

    List<Subject> getAllSubject();
}
