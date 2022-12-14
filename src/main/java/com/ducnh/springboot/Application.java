package com.ducnh.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@EntityScan("com.ducnh.springboot.entity")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class Application {

       public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}