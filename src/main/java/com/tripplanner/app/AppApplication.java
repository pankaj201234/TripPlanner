package com.tripplanner.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages= {"com.tripplanner"})

public class AppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
