package com.ntqsolution.demo.redis;

import com.google.gson.Gson;

public interface ConvertRedis<T> {
    Gson gson = new Gson();

    String convertToString(T t);

    T convertToObj(String string);
}
