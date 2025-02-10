package com.ecommerce.order_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Capability;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modeMapper() {
		return new ModelMapper();
	}

	@Bean
	public Capability capability(MeterRegistry meterRegistry) {
		return capability(meterRegistry);
	}

}
