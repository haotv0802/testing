/**
 * 
 */
package com.client.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.client.security.bean.CustomUserDetails;
import com.dao.model.UserModel;
import com.service.UserService;

/**
 * @author haho
 *
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userService.getUserByUserName(username);
		CustomUserDetails myUserDetails = new CustomUserDetails(userModel);
		return myUserDetails;
	}

}
