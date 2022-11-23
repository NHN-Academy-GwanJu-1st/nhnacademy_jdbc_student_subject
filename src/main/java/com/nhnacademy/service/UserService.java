package com.nhnacademy.service;

import com.nhnacademy.domain.User;

public interface UserService {
    boolean existUser(String userName);

    boolean login(String userName, String password);
}
