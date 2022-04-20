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
			userService.saveRole(new Role(null, "ROLE_ADMIN", new ArrayList<>()));
			userService.saveRole(new Role(null, "ROLE_USER", new ArrayList<>()));

			userService.saveUser(new User(null, "admin123@gmail.com", "admin", "12345678",
					"john", "snow", new Date(), new ArrayList<>()));
			userService.saveUser(new User(null, "user123@gmail.com", "user", "12345678",
					"tyrion", "lannister", new Date(), new ArrayList<>()));


			userService.addRoleToUser("admin", "ROLE_ADMIN");
			userService.addRoleToUser("admin", "ROLE_USER");
			userService.addRoleToUser("user", "ROLE_USER");


			/*
			userService.addRoleToUser("user1", "ROLE_USER");
			userService.addRoleToUser("user2", "ROLE_PLEB");
			*/

		};
	}
}
