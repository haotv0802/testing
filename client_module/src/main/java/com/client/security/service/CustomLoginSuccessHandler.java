/**
 * 
 */
package com.client.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author haho
 *
 */
@Component("customLoginSuccessHandler")
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//do some logic here if you want something to be done whenever
		//the user successfully logs in.
 
        HttpSession session = request.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());
 
        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);
 
        //since we have created our custom success handler, its up to us to where
        //we will redirect the user after successfully login
//        response.sendRedirect("home");
	}

}
