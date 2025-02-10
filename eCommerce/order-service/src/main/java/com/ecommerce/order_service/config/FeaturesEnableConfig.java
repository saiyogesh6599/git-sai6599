package com.ecommerce.order_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@RefreshScope
@Data
public class FeaturesEnableConfig {

    @Value("${features.user-tracking-enabled}")
    private boolean isUserTrackingEnabled;

}