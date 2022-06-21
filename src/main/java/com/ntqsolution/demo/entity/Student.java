package com.ntqsolution.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person {

    private int totalMark;


    public Student(String name, String personClass, int totalMark) {
        super(name, personClass);
        this.totalMark = totalMark;
    }

}
