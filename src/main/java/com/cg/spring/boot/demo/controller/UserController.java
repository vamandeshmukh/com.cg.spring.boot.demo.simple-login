package com.cg.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.service.AppUserService;

@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private AppUserService userService;

	@PostMapping("/register")
	public AppUser register(@RequestBody AppUser appUser) {
		log.info("registerController");
		return userService.register(appUser);
	}

//	@PostMapping("/login2")
//	public AppUser login2(@RequestBody AppUser appUser) {
//		log.info("loginController");
//		log.info(appUser.getUsername());
//		log.info(appUser.getPassword());
//		return userService.login(appUser);
//	}

	@PostMapping("/login")
	public AppUser login(@RequestBody AppUser appUser) {
		log.info("loginController");
		log.info(appUser.getUsername());
		log.info(appUser.getPassword());
		AppUser appUser2 = userService.login(appUser);
		if ((appUser.getUsername().equals(appUser2.getUsername())
				&& (appUser.getPassword().equals(appUser2.getPassword())))) {
			return appUser2;
		}
		return null;
	}

	@GetMapping("/logout")
	public String logout() {
		log.info("logoutController");
		return userService.logout();
	}
}
