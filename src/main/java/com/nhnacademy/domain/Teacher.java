package com.nhnacademy.domain;

import lombok.Value;

import java.util.Date;

@Value
public class Teacher {
    private final long id;
    private final String name;
    private final Date createdAt;
}
