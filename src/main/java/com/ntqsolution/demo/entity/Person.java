package com.ntqsolution.demo.entity;

import com.ntqsolution.demo.utils.Const;
import com.ntqsolution.demo.utils.Util;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Person extends AbstractEntity {
    private String id;
    private String name;
    private String personClass;

    public Person(String name, String personClass) {
        this.id = Util.getRandomUUID();
        this.name = name;
        this.personClass = personClass;
    }

}
