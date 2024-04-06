package com.livares.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.livares.product.model.AuthenticationSucessHandler;
import com.livares.product.service.CustomUserDetailsServiceImp;


@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsServiceImp customUserDetailsServiceImp; // creating the bean of this class . 
	
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
    	
    	
    	return http
                .csrf(csrf -> csrf.disable()) // csrf disabling 
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home", "/authentication/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasAnyRole("ADMIN", "USER"); // Allow both ADMIN and USER roles to access "/user/**" URLs
                    registry.anyRequest().authenticated();  // any request other than the specified one's that's requires authentication. 
        
                })
                .formLogin(login -> login
                        .permitAll() // Permit all requests to the default login page of Spring Boot
                        .successHandler(new AuthenticationSucessHandler())) // Chaining for additional configurations
                .build();
    }
    
    

    
    
    @Bean
    public UserDetailsService userDetailsService() {
    	return customUserDetailsServiceImp;
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); // for  loading users from the database and use it in the authentication
    	provider.setUserDetailsService(customUserDetailsServiceImp);
    	provider.setPasswordEncoder(passwordEncoder());
    	return provider;
    }
    
    
    // returning BCrypt encoder for password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
}












//  user and admin data storing in memory for In memory authentication testing

/** @Bean
UserDetailsService userDetailsService() {
	UserDetails normalUser = User.builder()
								.username("user")
								.password("$2a$12$08k7tqqv.q1WI/F6SDtsJesu/niAI.CTY0T2pz/cXeUbnQi1LNREa")
								.roles("USER")
								.build();
	UserDetails adminUser = User.builder()
			.username("admin")
			.password("$2a$12$4vGptdTAo1NBcWWMw1tQdunepMbztRs/e8eAcW6VZZK2hKPow8aby")
			.roles("USER","ADMIN")
			.build();
	return new InMemoryUserDetailsManager(normalUser,adminUser);
} */