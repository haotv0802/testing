/**
 * 
 */
package com.dao.model;

import java.util.List;

/**
 * @author haho
 *
 */
public class UserModel {
	private String userName;
	private String password;
	private List<RoleModel> roles;

	@Override
	public String toString() {
		return userName + " ";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public List<RoleModel> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
}
