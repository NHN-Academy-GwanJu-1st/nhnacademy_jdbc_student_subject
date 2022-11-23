package com.nhnacademy.controller;

import com.nhnacademy.domain.Course;
import com.nhnacademy.service.CourserService;
import com.nhnacademy.service.SubjectService;
import com.nhnacademy.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/course")
public class CourseController {

    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final CourserService courserService;

    public CourseController(TeacherService teacherService, SubjectService subjectService, CourserService courserService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.courserService = courserService;
    }

    @GetMapping
    public String courseHome(Model model) {

        List<Course> allCourse = courserService.getAllCourse();
        model.addAttribute("courses", allCourse);

        return "view/course/index";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {

        model.addAttribute("allSubject", subjectService.getAllSubject());
        model.addAttribute("allTeacher", teacherService.getAllTeacher());

        return "view/course/register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam(value = "subjectId") long subjectId,
                             @RequestParam(value = "teacherId") long teacherId) {

        log.info("teacherId {}", teacherId);
        log.info("subjectId {}", subjectId);

        courserService.registerCourse(teacherId, subjectId);

        return "redirect:/course";
    }

    @GetMapping("/modify/{courseId}")
    public String getModify(@PathVariable(value = "courseId") long courseId, Model model) {
        model.addAttribute("courseId", courseId);
        model.addAttribute("allSubject", subjectService.getAllSubject());
        model.addAttribute("allTeacher", teacherService.getAllTeacher());

        return "view/course/modify";
    }

    @PostMapping("/modify")
    public String doRegister(@RequestParam(value = "courseId") long courseId,
                             @RequestParam(value = "subjectId") long subjectId,
                             @RequestParam(value = "teacherId") long teacherId) {

        courserService.modifyCourse(courseId, subjectId, teacherId);

        return "redirect:/course";
    }

    @GetMapping("/delete/{courseId}")
    public String doDelete(@PathVariable(value = "courseId") long courseId) {

        courserService.deleteCourse(courseId);

        return "redirect:/course";
    }
}
