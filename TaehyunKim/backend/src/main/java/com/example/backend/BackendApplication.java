package com.example.backend;

import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();}

	@Bean
	CommandLineRunner run(UserService userService){
		return args ->{
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_PLEB"));

			userService.saveUser(new User(null, "johnsnow", "password", new ArrayList<>(), "johnsnow@gmail.com",
					"John", "Snow", new Date()));
			userService.saveUser(new User(null, "tyrionlannister", "password123", new ArrayList<>(), "tyrionlannister@gmail.com",
					"Tyrion", "Lannister", new Date()));
			userService.saveUser(new User(null, "hodor", "password456", new ArrayList<>(), "hodor@gmail.com",
					"Hodor", null, new Date()));

			userService.addRoleToUser("johnsnow", "ROLE_ADMIN");
			userService.addRoleToUser("johnsnow", "ROLE_USER");
			userService.addRoleToUser("tyrionlannister", "ROLE_USER");
			userService.addRoleToUser("hodor", "ROLE_PLEB");


		};
	}
}
