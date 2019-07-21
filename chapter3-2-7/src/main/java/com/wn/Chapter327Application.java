package com.wn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Chapter327Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter327Application.class, args);
    }

}
