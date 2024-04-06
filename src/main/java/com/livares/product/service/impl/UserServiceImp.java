package com.livares.product.service.impl;

import com.livares.product.Dto.LoginDTO;
import com.livares.product.Dto.UserDTO;
import com.livares.product.exception.CustomException;
import com.livares.product.exception.ErrorCode;
import com.livares.product.model.User;
import com.livares.product.repository.UserRepository;
import com.livares.product.service.UserService;

import lombok.experimental.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * =====================================================================
     * Registers a new user with the provided user information.
     * Checking the database if the username already  exists .
     *
     *  @param userDTO The DTO containing user information for registration
     * @return A string indicating the result of the registration process
     * =====================================================================
     */
//    @Overridek
    public String registerUser(UserDTO userDTO) {
    	// Check if the username already exists
        if (!userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
        // Create a new User object and set its properties from the DTO
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());
        // Save the user to the database
        userRepository.save(user);
        return "User Registered Sucessfully";
        } else throw new CustomException(ErrorCode.BAD_REQUEST,"username is already exists") ;
    }

//
//    /**
//     * =====================================================================
//     * Authenticates a user login based on the provided login credentials.
//     *
//     * @param loginDTO The DTO containing user login credentials
//     * @return A string indicating the result of the login attempt
//     * ========================================================================
//     */
    @Override
    public String loginUser(LoginDTO loginDTO) {
    	try {
			
    	      // Find the user by username
            Optional<User> user = userRepository.findByUsername(loginDTO.getUsername());
            // Check if the user exists
            if (user.isPresent()) {
                // Get the encoded password stored in the database
                String encodedPasword = user.get().getPassword();
                // Get the password input by the user
                String inputPassword = loginDTO.getPassword();
                // Check if the input password matches the stored encoded password
                Boolean isPwdRight = passwordEncoder.matches(inputPassword, encodedPasword);

                if (isPwdRight) return "user sucessfully logined"; 
                else throw new CustomException(ErrorCode.BAD_REQUEST,"password is false") ;
            }else throw new CustomException(ErrorCode.BAD_REQUEST, loginDTO.getUsername() + ": username  is not exist");
    			
		} catch (Exception e) {
			throw new CustomException(e);
		}
			
		
  
    }



	
}
