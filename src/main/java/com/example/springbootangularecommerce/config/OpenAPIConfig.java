package com.example.springbootangularecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Springboot-Angular-Ecommerce API",
                version = "v1.0",
                description = "This is a customized API description",
                termsOfService = "http://example.com/terms",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Sophiesung96 Repo",
                        url = "http://example.com/support",
                        email = "support@example.com"
                ),
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "API License",
                        url = "http://example.com/license"
                )
        )
)
public class OpenAPIConfig {
}
