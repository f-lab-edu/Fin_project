package com.example.springbootlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan(basePackages={"com.example.springbootlogin.controller"})
public class SpringbootloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootloginApplication.class, args);
    }

}
