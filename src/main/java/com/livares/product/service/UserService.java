package com.livares.product.service;

import com.livares.product.Dto.LoginDTO;
import com.livares.product.Dto.UserDTO;

public interface UserService  {

	// register a new user to the database 
	public String registerUser(UserDTO userDTO);
	
	public String loginUser(LoginDTO loginDTO);
}
