package com.example.backend;

import com.example.backend.entity.Post;
import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import com.example.backend.service.PostService;
import com.example.backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
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
	CommandLineRunner run(UserService userService, PostService postService){
		return args ->{
			userService.saveRole(new Role(null, "ROLE_ADMIN", new ArrayList<>()));
			Role role = userService.saveRole(new Role(null, "ROLE_USER", new ArrayList<>()));

			User admin = userService.saveUser(new User(null, "admin123@gmail.com", "admin", "password",
					"john", "snow", new Date() , new ArrayList<>(), new ArrayList<>()));
			User user = userService.saveUser(new User(null, "user123@gmail.com", "user", "password",
					"tyrion", "lannister", new Date(), new ArrayList<>(), new ArrayList<>()));


			userService.addRoleToUser("admin", "ROLE_ADMIN");


			for (int i =0; i<5; i++){
				postService.createPost(new Post(null, "title_"+ i, "writer_"+ i, "content_"+ i,
						null, 0, null, null));
			}

			//postService.createPost(new Post(null, "Catcher in the rye", "Sandler", "Caulfield", null, 0, admin));

			/*
			userService.addRoleToUser("user1", "ROLE_USER");
			userService.addRoleToUser("user2", "ROLE_PLEB");
			*/

		};
	}
}
