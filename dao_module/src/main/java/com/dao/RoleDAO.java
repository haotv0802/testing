/**
 * 
 */
package com.dao;

import java.util.List;

import com.dao.model.RoleModel;

/**
 * @author haho
 *
 */
public interface RoleDAO {
	List<RoleModel> getRolesByUsername(String username);
	
	void insertRoleDetails(int id, String name);
}
