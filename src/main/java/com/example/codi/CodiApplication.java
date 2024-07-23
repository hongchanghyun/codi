package com.example.codi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CodiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodiApplication.class, args);
    }

}
