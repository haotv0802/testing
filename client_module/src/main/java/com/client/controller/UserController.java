/**
 * 
 */
package com.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author haho
 *
 */
@Controller
public class UserController {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView display(HttpServletRequest request) {
		String referrer = request.getHeader("Referer");
		LOGGER.info("referrer: " + referrer);
		return new ModelAndView("login");
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public void login(@RequestBody LoginForm loginForm, HttpServletResponse response) throws IOException {
////		return new ModelAndView("login");
//		response.sendRedirect("/svc/user/getUserByUserName?userName=admin");
//	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
}
