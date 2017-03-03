/**
 * 
 */
package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RoleDAO;
import com.dao.UserDAO;
import com.dao.model.RoleModel;
import com.dao.model.UserModel;
import com.service.UserService;

/**
 * @author haho
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	public UserModel getUserByUserName(String userName) {
//		roleDAO.insertRoleDetails(46, "46");
		UserModel userModel = userDAO.getUserByUsername(userName);
		List<RoleModel> roleModelList = roleDAO.getRolesByUsername(userModel.getUserName());
		userModel.setRoles(roleModelList);
		return userModel;
	}

}
