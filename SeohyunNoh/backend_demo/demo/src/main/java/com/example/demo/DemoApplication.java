package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpSessionListener;

@SpringBootApplication
public class DemoApplication{

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
