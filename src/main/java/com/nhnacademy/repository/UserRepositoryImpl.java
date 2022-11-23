package com.nhnacademy.repository;

import com.nhnacademy.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    @Override
    public boolean exist(String userName) {
        String sql = "SELECT COUNT(*) FROM JdbcUsers WHERE username = ?";

        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, userName);

        if (result.intValue() == 0) {
            return false;
        }

        return true;
    }

    @Transactional
    @Override
    public User getUser(String userName) {
        String sql = "SELECT id, username, password, created_at FROM JdbcUsers WHERE username = ?";

        return jdbcTemplate.queryForObject(
                sql, (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getTimestamp("created_at")
                        ), userName);
    }

//    @Override
//    public boolean match(Long id, String userName, String password) {
//        return Optional.ofNullable(getUser(id))
//                .map(user -> user.getUserName().equals(userName) && user.getPassword().equals(password))
//                .orElse(false);
//    }
}
