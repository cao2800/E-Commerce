package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Model.User;
import com.ecommerce.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void addUser(User user) {
		System.out.println("Email" + user.getEmail());
		System.out.println("First " + user.getFirstName());
		System.out.println("Last Name" + user.getLastName());
		userRepository.save(user);
	}
	
}
