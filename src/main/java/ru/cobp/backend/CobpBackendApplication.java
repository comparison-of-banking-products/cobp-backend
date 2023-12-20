package ru.cobp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CobpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CobpBackendApplication.class, args);
    }

}
