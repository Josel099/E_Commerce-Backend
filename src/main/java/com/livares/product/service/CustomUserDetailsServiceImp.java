package com.livares.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.livares.product.model.User;
import com.livares.product.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;


	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isPresent()) {
			User userObj = user.get();
			return org.springframework.security.core.userdetails.User.builder()
					.username(userObj.getUsername())
					.password(userObj.getPassword())
					.roles(getRoles(userObj))
					.build();
		}else {
			throw new UsernameNotFoundException(username);
		}}

	
	
	
	
	
	private String[] getRoles(User userObj) {
	if(userObj.getRole() == null) return new String[] {"USER"};
	return userObj.getRole().split(",");
		}

}
