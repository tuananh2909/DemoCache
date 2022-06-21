package com.ntqsolution.demo.utils;

import java.util.Random;

public class PersonUtil {
    public static int getRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
