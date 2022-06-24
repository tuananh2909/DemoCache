package com.ntqsolution.demo.utils;

import java.util.UUID;

public class Util {

    public static String getRandomUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }
}
