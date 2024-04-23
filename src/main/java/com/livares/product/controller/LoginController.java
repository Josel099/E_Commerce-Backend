package com.livares.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.livares.product.Dto.LoginDTO;
import com.livares.product.Dto.LoginResponse;
import com.livares.product.model.User;
import com.livares.product.response.ResponseHandler;
import com.livares.product.service.impl.AuthenticationService;
import com.livares.product.service.impl.JwtService;

@RestController

public class LoginController {

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<Object> findById(@RequestBody LoginDTO userDto) {
		User authenticatedUser = authenticationService.authenticate(userDto);

		String jwtToken = jwtService.generateToken(authenticatedUser);

		LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

		return ResponseHandler.generateResponse("Success", HttpStatus.OK, loginResponse);

	}
}
