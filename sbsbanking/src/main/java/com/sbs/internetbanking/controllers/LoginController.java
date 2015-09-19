package com.sbs.internetbanking.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sbs.internetbanking.model.User;
import com.sbs.internetbanking.persistence.UserManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserManager userManager;

	@Autowired
	MessageSource messageSource;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		User user = new User();
		user.setEmail("blah@asu.edu");
		user.setId("j10021645");
		user.setPassword("blah12blah");
		user.setUsername("blahbl45ah");
		userManager.saveUser(user);
		model.addAttribute("welcome", messageSource.getMessage("message.welcome", null, Locale.US));
		return "login";
	}
	
	

}
