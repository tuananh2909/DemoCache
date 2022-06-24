package com.ntqsolution.demo.utils;

import com.google.gson.Gson;
import com.ntqsolution.demo.entity.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GsonUtil {

    static Gson gson = new Gson();

    public static Object convertToObject(String stringObject) {
        return gson.fromJson(stringObject, Student.class);
    }

    public static String convertFromObject(Object obj) {
        return gson.toJson(obj);
    }

}
