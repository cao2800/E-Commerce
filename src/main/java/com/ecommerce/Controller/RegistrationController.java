package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Model.User;
import com.ecommerce.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/registerUser")
	public void registerUser(@RequestBody User user) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
		service.addUser(user);
	}

}
