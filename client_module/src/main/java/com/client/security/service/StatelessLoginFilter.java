/**
 * 
 */
package com.client.security.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.client.form.LoginForm;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author haho
 *
 */
@Component("statelessLoginFilter")
public class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

//	@Autowired
//	@Qualifier("statelessLoginFailureHandler")
//	private StatelessLoginFailureHandler failureHandler;
	
	public StatelessLoginFilter() {
		// super(requiresAuthenticationRequestMatcher);
		super(new AntPathRequestMatcher("/login", HttpMethod.POST.toString()));
//		setAuthenticationFailureHandler(new StatelessLoginFailureHandler());
//		setAuthenticationFailureHandler(failureHandler);
//		setAuthenticationSuccessHandler(new CustomLoginSuccessHandler());
//		setAuthenticationManager(getAuthenticationManager());
	}

	@Autowired
	@Qualifier(value = "customLoginSuccessHandler")
	@Override
	public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
		super.setAuthenticationSuccessHandler(successHandler);
	}

	@Autowired
	@Override
	@Qualifier(value = "customLoginFailureHandler")
	public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
		super.setAuthenticationFailureHandler(failureHandler);
	}

	@Override
	@Autowired
	@Qualifier(value = "authenticationManager")
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		LOGGER.debug("START attemptAuthentication");
		LoginForm loginForm = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
		LOGGER.debug("END attemptAuthentication");
		return getAuthenticationManager().authenticate(token);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
//		super.successfulAuthentication(request, response, chain, authResult);
		// Add the authentication to the Security context
		SecurityContextHolder.getContext().setAuthentication(authResult);
	}
}
