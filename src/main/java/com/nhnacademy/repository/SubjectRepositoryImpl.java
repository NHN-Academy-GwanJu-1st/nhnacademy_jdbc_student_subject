package com.nhnacademy.repository;

import com.nhnacademy.domain.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    private final JdbcTemplate jdbcTemplate;

    public SubjectRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    @Override
    public Subject findById(long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcSubjects  where id = ?",
                (rs, rowNum) ->
                        new Subject(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at")),
                id);
    }

    @Transactional
    @Override
    public List<Subject> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcSubjects",
                (rs, rowNum) ->
                        new Subject(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at"))
                );
    }
}
