/**
 * 
 */
package com.client.security.service;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author haho
 *
 */
public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {
	protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub - check if user is unblocked or not.
		this.LOGGER.debug("START CustomDaoAuthenticationProvider");
		return super.authenticate(authentication);
	}
}
