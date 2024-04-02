package com.livares.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.livares.product.Dto.UserDTO;
import com.livares.product.model.User;
import com.livares.product.repository.UserRepository;
import com.livares.product.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Implementation for registering the user
	@Override
	public String registerUser(UserDTO userDTO) {

		if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
			return "username is already exists";
		}

		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		userRepository.save(user);
		return "User Registered Sucessfully  ";
	}

}
