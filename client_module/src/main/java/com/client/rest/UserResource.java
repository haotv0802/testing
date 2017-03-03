/**
 * 
 */
package com.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.model.UserModel;
import com.service.UserService;

/**
 * @author haho
 *
 */
@RestController
@RequestMapping(path = "/svc/user")
public class UserResource extends ResourceBase {
	@Autowired
	private UserService userService;

	@PreAuthorize("@userResourceAuthority.hasPermission(#userName)")
	@RequestMapping(value = "/getUserByUserName", method = RequestMethod.GET)
	public UserModel getUserByUserName(@RequestParam(name = "userName", required = true) String userName) {
		UserModel userModel = userService.getUserByUserName(userName);
		return userModel;
	}
}
