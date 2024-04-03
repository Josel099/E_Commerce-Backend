package com.livares.product.service;

import com.livares.product.Dto.LoginDTO;
import com.livares.product.Dto.UserDTO;

public interface UserService  {

	// register a new user to the database 
    String registerUser(UserDTO userDTO);

	// login a user
	String loginUser(LoginDTO loginDTO);
}
