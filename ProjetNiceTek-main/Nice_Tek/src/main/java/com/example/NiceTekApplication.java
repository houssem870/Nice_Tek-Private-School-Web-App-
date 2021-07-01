package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
public class NiceTekApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiceTekApplication.class, args);
	}

}
