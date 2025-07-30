package com.clubee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.clubee.infra.database.model")
public class ClubeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubeeApplication.class, args);
	}

}
