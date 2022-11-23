package com.nhnacademy.service;

import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existUser(String userName) {

        if (userRepository.exist(userName)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean login(String userName, String password) {
        User user = userRepository.getUser(userName);

        if (user.getPassword().equals(password)) {
            return true;
        }

        return false;
    }

}
