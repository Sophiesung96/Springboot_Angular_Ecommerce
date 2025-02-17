package com.example.springbootangularecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfiguration {


    private final CustomAccessDeniedHandler accessDeniedHandler;

    public SecurityConfiguration( CustomAccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;}
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, CustomAccessDeniedHandler customAccessDeniedHandler) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for REST APIs
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/orders/**").authenticated()
                        .anyRequest().permitAll() )
                        .oauth2ResourceServer(oauth2 -> oauth2
                                .jwt(jwt -> {}))
                .exceptionHandling(exception->
                        //dealing 403 Forbidden using CustomAccessDenialHandler class
                        exception.accessDeniedHandler(accessDeniedHandler))
                // Ensure security error responses (e.g., authentication errors) use proper content type
                .setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy() {});

        //force a non-empty response body for 401 to make the response more friendly
        Okta.configureResourceServer401ResponseBody(http);
               return http.build();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("https://localhost:4200")); // Use the same origin as in MyDataRestConfig
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
