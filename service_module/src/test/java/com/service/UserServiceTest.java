/**
 * 
 */
package com.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.RoleDAO;
import com.dao.model.UserModel;

/**
 * @author haho
 *
 */
public class UserServiceTest extends AbstractServiceTest {

	@Override
	public void startUp() {
		// TODO Auto-generated method stub
	}

	@Override
	public void tearDown() {
		// TODO Auto-generated method stub
	}

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDAO roleDAO;

	@Test
	public void testGetUserByUserName() {
//		roleDAO.insertRoleDetails();
		UserModel userModel = userService.getUserByUserName("haho");
		Assert.assertNotNull(userModel);
	}

}
