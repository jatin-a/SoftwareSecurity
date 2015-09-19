package com.sbs.internetbanking.controllers;

import java.text.DateFormat;
import java.util.Date;
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
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserManager userManager;

	@Autowired
	MessageSource messageSource;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		User user = new User();
		user.setEmail("blah@asu.edu");
		user.setId("j100216");
		user.setPassword("blahblah");
		user.setUsername("blahblah");
		userManager.saveUser(user);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("welcome", messageSource.getMessage("message.welcome", null, Locale.US));
		return "home";
	}

	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public String myAccount(Locale locale, Model model) {
		model.addAttribute("welcome", messageSource.getMessage("message.welcome", null, Locale.US));
		return "home";
	}
}