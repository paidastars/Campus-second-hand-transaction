package com.zsy.xyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zsy"})
public class XyappApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyappApplication.class, args);
    }

}
