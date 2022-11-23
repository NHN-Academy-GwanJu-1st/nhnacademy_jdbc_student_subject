package com.nhnacademy.repository;

import com.nhnacademy.domain.Subject;

import java.util.List;

public interface SubjectRepository {
    Subject findById(long id);

    List<Subject> findAll();
}
