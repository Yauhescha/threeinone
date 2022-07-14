package com.hescha.threeinone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreeinoneApplication {
    public static final String LOG_TOPIC = "LOG_TOPIC";

    public static void main(String[] args) {
        SpringApplication.run(ThreeinoneApplication.class, args);
    }

}
