package com.nhnacademy.repository;

import com.nhnacademy.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private Map<Long, User> users = new HashMap<>();

    @Override
    public boolean exist(Long id) {
        return users.containsKey(id);
    }

    @Override
    public User getUser(Long id) {
        return exist(id) ? users.get(id) : null;
    }

    @Override
    public boolean match(Long id, String userName, String password) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getUserName().equals(userName) && user.getPassword().equals(password))
                .orElse(false);
    }
}
