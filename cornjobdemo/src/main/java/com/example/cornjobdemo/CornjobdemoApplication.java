package com.example.cornjobdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CornjobdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CornjobdemoApplication.class, args);
	}

}
