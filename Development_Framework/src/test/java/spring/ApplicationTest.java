package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evolution.Application;

@SpringBootApplication// Define it for spring boot test. 
public class ApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}