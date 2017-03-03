/**
 * 
 */
package com.client.security.bean;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dao.model.RoleModel;
import com.dao.model.UserModel;

/**
 * @author haho
 *
 */
public class CustomUserDetails implements UserDetails {

	private String username;

	private String password;
	
	private Set<GrantedAuthority> grantedAuthorities;

	public CustomUserDetails(UserModel userModel) {
		this.username = userModel.getUserName();
		this.password = userModel.getPassword();
		this.buildGrantedAuthorities(userModel);
	}
	
	private void buildGrantedAuthorities(UserModel userModel) {
		List<RoleModel> roleModelList = userModel.getRoles();
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (RoleModel roleModel : roleModelList) {
			CustomAuthority myAuthority = new CustomAuthority(roleModel.getRoleName());
			grantedAuthorities.add(myAuthority);
		}
		this.grantedAuthorities = grantedAuthorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.grantedAuthorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
