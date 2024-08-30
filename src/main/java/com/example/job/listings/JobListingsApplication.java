package com.example.job.listings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class JobListingsApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		// Set environment variables for Spring Boot
		System.setProperty("DATABASE_USERNAME", dotenv.get("DATABASE_USERNAME"));
		System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));
		System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
		SpringApplication.run(JobListingsApplication.class, args);
	}

}
