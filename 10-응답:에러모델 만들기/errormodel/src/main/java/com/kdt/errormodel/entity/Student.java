package com.kdt.errormodel.entity;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

}
