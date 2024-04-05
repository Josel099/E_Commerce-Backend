package com.livares.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
//        http.csrf(csrf -> csrf.disable());
//    	  return http.build();
    	
    	
    	return http.authorizeHttpRequests(registry->{
    			registry.requestMatchers("/home").permitAll();           
    			registry.requestMatchers("/admin/**").hasRole("ADMIN");
    			registry.requestMatchers("/user/**").hasRole("USER");
    			registry.anyRequest().authenticated();  // any request other than the specified one's that's requires authentication. 
    	})
    			.formLogin(formLogin->formLogin.permitAll()) // customizing the  default login page for permitting for all request. 
    			.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
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
    }
    
    
    
    
    
    // returning BCrypt encoder for password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
}