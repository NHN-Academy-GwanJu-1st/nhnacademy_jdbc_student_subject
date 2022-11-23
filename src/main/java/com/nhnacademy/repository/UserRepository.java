package com.nhnacademy.repository;

import com.nhnacademy.domain.User;

import java.util.Optional;

public interface UserRepository {

    boolean exist(String userName);
    User getUser(String userName);
}
