package com.nhnacademy.domain;

import lombok.Value;

import java.util.Date;

@Value
public class User {
    private final Long id;
    private final String userName;
    private final String password;
    private final Date createdAt;

}
