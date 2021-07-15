package com.simple.catculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CatculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatculatorApplication.class, args);
    }

}
