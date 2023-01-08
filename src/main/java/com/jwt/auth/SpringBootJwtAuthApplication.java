package com.jwt.auth;

import com.jwt.auth.security.User;
import com.jwt.auth.security.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootJwtAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthApplication.class, args);
	}

	@GetMapping
	public String greeting() {
		return "Hello";
	}

	@Autowired
	private UserRepo userRepo;

	@Bean
	public CommandLineRunner runner() {
		return t -> {
			User user = new User();
			user.setUsername("Admin");
			user.setPassword("12345678");
			userRepo.save(user);
		};
	}

}
