package com.nhnacademy.controller;

import com.nhnacademy.exception.UserNotFoundException;
import com.nhnacademy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password,
                          HttpServletRequest request) {

        if (!userService.existUser(username)) {
            throw new UserNotFoundException();
        }

        if (userService.login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", username);
        }

        return "redirect:/course";
    }
}