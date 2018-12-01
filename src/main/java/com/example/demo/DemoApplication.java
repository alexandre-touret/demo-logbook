package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zalando.logbook.Conditions;
import org.zalando.logbook.JsonHttpLogFormatter;
import org.zalando.logbook.Logbook;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Logbook createLogBook() {
        // too easy : return Logbook.create();
        return Logbook.builder()
                .condition(Conditions.requestTo("/helloworld"))
                .formatter(new JsonHttpLogFormatter())
                .build();
    }
}
