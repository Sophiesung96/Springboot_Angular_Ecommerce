package com.example.springbootangularecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyAppConfig implements WebMvcConfigurer {

    @Value("${spring.rest.base-path}")
    private String [] allowedOrigins;
    @Value("${allowed-origin)}")
    private String basePath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping(basePath+"/**").allowedOrigins(allowedOrigins);
    }
}
