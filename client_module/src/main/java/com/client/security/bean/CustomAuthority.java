/**
 * 
 */
package com.client.security.bean;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author haho
 *
 */
public class CustomAuthority implements GrantedAuthority {

	private String name;

	public CustomAuthority(String authorityName) {
		this.name = authorityName;
	}

	public String getAuthority() {
		return this.name;
	}
}
