package com.ideas2it.user.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class UserController {

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String getEmployees(Principal principal) {
		return "Welcome!" + principal.getName();
	}
}