package com.rs.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FERApplication {

	public static void main(String[] args) {
		SpringApplication.run(FERApplication.class, args);
	}
	
}
