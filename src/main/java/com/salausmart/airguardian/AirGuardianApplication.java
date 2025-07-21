package com.salausmart.airguardian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AirGuardianApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirGuardianApplication.class, args);
    }

}
