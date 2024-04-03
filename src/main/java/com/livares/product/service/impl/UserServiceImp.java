package com.livares.product.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.livares.product.Dto.LoginDTO;
import com.livares.product.Dto.UserDTO;
import com.livares.product.model.User;
import com.livares.product.repository.UserRepository;
import com.livares.product.service.UserService;

import ch.qos.logback.core.joran.conditional.IfAction;

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
		return "User Registered Sucessfully";
	}
	
	// login user
	
	@Override
	public String loginUser(LoginDTO loginDTO) {
	
		Optional<User> user  = userRepository.findByUsername(loginDTO.getUsername());
		if(user.isPresent()) {
			String encodedPasword = user.get().getPassword();
			String inputPassword  = loginDTO.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(inputPassword,encodedPasword);// checking the input pwd is match with the orginal pwd
			
			if(!isPwdRight) return "password is false";
			else return "user sucessfully logined";
		}
		
		return "username is not exist";
	}
}
