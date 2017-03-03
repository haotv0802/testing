/**
 * 
 */
package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.dao.RoleDAO;
import com.dao.model.RoleModel;
import com.dao.test.AbstractDAOTest;

/**
 * @author haho
 *
 */
public class RoleDAOTest extends AbstractDAOTest {

	@Autowired
	private RoleDAO roleDAO;

	@Override
	public void startUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tearDown() {
		// TODO Auto-generated method stub

	}

	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Test
	public void testGetRolesByUsername() {
		List<RoleModel> roleModelList = roleDAO.getRolesByUsername("haho");
		Assert.assertNotNull(roleModelList);
	}
}