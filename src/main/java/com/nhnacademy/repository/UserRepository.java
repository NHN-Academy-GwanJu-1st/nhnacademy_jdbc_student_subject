package com.nhnacademy.repository;

import com.nhnacademy.domain.User;

public interface UserRepository {

    boolean exist(Long id);

    User getUser(Long id);

    boolean match(Long id, String userName, String password);
}
