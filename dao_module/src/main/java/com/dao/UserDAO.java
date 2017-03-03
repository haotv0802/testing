/**
 * 
 */
package com.dao;

import com.dao.model.UserModel;

/**
 * @author haho
 *
 */
public interface UserDAO {
	UserModel getUserByUsername(String name);
}
