package com.ecommerce.inventory_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import feign.Capability;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modeMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestClient restClient() {
		return RestClient.builder().build(); 
	}
	
	@Bean
	public Capability capability(MeterRegistry meterRegistry) {
		return capability(meterRegistry);
	}
}
