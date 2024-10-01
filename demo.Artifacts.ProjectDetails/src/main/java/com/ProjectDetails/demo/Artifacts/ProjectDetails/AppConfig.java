package com.ProjectDetails.demo.Artifacts.ProjectDetails;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope("singleton")
	Apple getConfig() {
		return new Apple();
	}

}
