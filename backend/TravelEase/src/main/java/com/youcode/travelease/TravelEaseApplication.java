package com.youcode.travelease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@SpringBootApplication
public class TravelEaseApplication {
    public static void main ( String[] args ) {
        SpringApplication.run ( TravelEaseApplication.class , args );
    }
}
