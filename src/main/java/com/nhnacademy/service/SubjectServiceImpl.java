package com.nhnacademy.service;

import com.nhnacademy.domain.Subject;
import com.nhnacademy.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject getSubject(long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

}
