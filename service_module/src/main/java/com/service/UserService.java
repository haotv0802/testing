/**
 * 
 */
package com.service;

import com.dao.model.UserModel;

/**
 * @author haho
 *
 */
public interface UserService {
	UserModel getUserByUserName(String userName);
}
