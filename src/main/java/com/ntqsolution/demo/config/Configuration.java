package com.ntqsolution.demo.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;

public class Configuration {

    @Bean
    public Gson createBean() {
        return new Gson();
    }
}
