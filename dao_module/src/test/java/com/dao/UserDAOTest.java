/**
 * 
 */
package com.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDAO;
import com.dao.model.UserModel;
import com.dao.test.AbstractDAOTest;

/**
 * @author haho
 *
 */
public class UserDAOTest extends AbstractDAOTest {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void startUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tearDown() {
		// TODO Auto-generated method stub

	}

	@Test
	public void testGetUserByUsername() {
		UserModel userModel = userDAO.getUserByUsername("haho");
		Assert.assertNotNull(userModel);
	}
}