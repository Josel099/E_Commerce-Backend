package com.livares.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livares.product.Dto.LoginDTO;
import com.livares.product.Dto.UserDTO;
import com.livares.product.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserService userService;
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody UserDTO userDTO) {
		return userService.registerUser(userDTO);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> authenticateUser(LoginDTO loginDTO){
		String reString = userService.loginUser(loginDTO);
		return ResponseEntity.ok(reString);
		
	}
	
}
