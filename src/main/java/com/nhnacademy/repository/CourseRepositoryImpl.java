package com.nhnacademy.repository;

import com.nhnacademy.domain.Course;
import com.nhnacademy.domain.Subject;
import com.nhnacademy.domain.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final JdbcTemplate jdbcTemplate;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public CourseRepositoryImpl(DataSource dataSource, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Transactional
    @Override
    public List<Course> findAll() {

        return jdbcTemplate.query(
                "SELECT id, teacher_id, subject_id, created_at FROM JdbcCourses",
                (rs, rowNum) ->
                        new Course(
                                rs.getLong("id"),
                                teacherRepository.findById(rs.getLong("teacher_id")),
                                subjectRepository.findById(rs.getLong("subject_id")),
                                rs.getTimestamp("created_at")
                        )
        );
    }

    @Transactional
    @Override
    public void register(long teacherId, long subjectId) {
        jdbcTemplate.update(
                "INSERT INTO JdbcCourses(teacher_id, subject_id, created_at) VALUES(? ,?, now())",
                subjectId,
                teacherId
        );
    }

    @Override
    public void modify(long id, long subjectId, long teacherId) {
        jdbcTemplate.update(
                "UPDATE JdbcCourses SET teacher_id = ?, subject_id = ? WHERE id = ?",
                teacherId,
                subjectId,
                id
        );
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(
                "DELETE FROM JdbcCourses WHERE id = ?",
                id
        );
    }
}
