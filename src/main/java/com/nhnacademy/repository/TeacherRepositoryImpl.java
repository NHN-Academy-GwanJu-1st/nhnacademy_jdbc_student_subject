package com.nhnacademy.repository;

import com.nhnacademy.domain.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    private final JdbcTemplate jdbcTemplate;

    public TeacherRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    @Override
    public Teacher findById(long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcTeachers  where id = ?",
                (rs, rowNum) ->
                        new Teacher(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at")),
                id);
    }

    @Transactional
    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcTeachers",
                (rs, rowNum) ->
                        new Teacher(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at"))
                );
    }
}
