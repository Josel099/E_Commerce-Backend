package com.livares.product.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.livares.product.repository.UserRepository;

@Service
public class CustomUserDetailServiceImp implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<com.livares.product.model.User> user = userRepo.findByUsername(username);
		if (user.isPresent()) {
			var userObj = user.get();
			return User.builder().username(userObj.getUsername()).password(userObj.getPassword()).roles().build();
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

}
