package com.livares.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    /**
     * Configures the security filter chain to disable CSRF protection.
     * CSRF protection is disabled because Spring Boot automatically enables CSRF protection by default,
     * which can cause errors in security configurations.
     * @param http The HttpSecurity object to configure
     * @return The configured SecurityFilterChain object
     * @throws Exception If an error occurs while configuring the security filter chain
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
    
    
    
    
    // returning BCrypt encoder for password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
}