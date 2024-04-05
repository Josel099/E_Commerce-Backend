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

	
	
	
	
	/**============================================================================
	 * Retrieves the roles associated with a user.
	 * If the user has no roles, it returns an array containing a single role "USER".
	 * Otherwise, it splits the role string using the comma (,) as the delimiter  into an array of individual roles and returns it.
	 * 
	 * @param userObj The User object for which roles are to be retrieved
	 * @return An array of roles associated with the user
	 * ============================================================================+*/
	private String[] getRoles(User userObj) {
	if(userObj.getRole() == null) return new String[] {"USER"};
	return userObj.getRole().split(",");
		}

}

