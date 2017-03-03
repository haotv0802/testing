/**
 * 
 */
package com.client.rest;

import org.springframework.stereotype.Component;

/**
 * @author haho
 *
 */
@Component("userResourceAuthority")
public class UserResourceAuthority {
	public boolean hasPermission(String userName) {
		if ("".equals(userName) || "HAO".equals(userName)) {
			return false;
		} else {
			return true;
		}
	}
}
