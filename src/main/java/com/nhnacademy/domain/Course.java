package com.nhnacademy.domain;

import lombok.Value;

import java.util.Date;

@Value
public class Course {
    private final long id;
    private final Teacher teacher;
    private final Subject subject;
    private final Date createdAt;
}
