package com.nhnacademy.service;

import com.nhnacademy.domain.Course;
import com.nhnacademy.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourserServiceImpl implements CourserService {

    private final CourseRepository courseRepository;

    public CourserServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void registerCourse(long teacherId, long subjectId) {
        courseRepository.register(teacherId, subjectId);
    }

    @Override
    public void modifyCourse(long id, long teacherId, long subjectId) {
        courseRepository.modify(id, teacherId, subjectId);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.delete(id);
    }
}
