package com.ntqsolution.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher extends Person {
    public String subject;

    public Teacher(String name, String personClass, String subject) {
        super(name, personClass);
        this.subject = subject;
    }

}
