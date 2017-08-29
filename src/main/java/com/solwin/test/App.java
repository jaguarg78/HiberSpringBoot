package com.solwin.test;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//@RestController
//@EnableAutoConfiguration
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class App {
//	@RequestMapping("/")
//	String hello() {
//		return "Hello World!";
//	}
//	
//	@RequestMapping("/test")
//	String test() {
//		return "Test!";
//	}
//	
//	@GetMapping("/article/{id}")
//	String testGetMapping(){
//		return "Test GetMapping!!";
//	}
	
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}
