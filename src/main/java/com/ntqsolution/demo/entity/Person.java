package com.ntqsolution.demo.entity;

import com.ntqsolution.demo.utils.Const;
import com.ntqsolution.demo.utils.PersonUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private String personClass;

    public Person(String name, String personClass) {
        this.id = PersonUtil.getRandomInt(Const.MAX_ID);
        this.name = name;
        this.personClass = personClass;
    }

}
