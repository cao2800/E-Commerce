package com.ecommerce.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.LoginDto;
import com.ecommerce.dto.RegisterDto;
import com.ecommerce.model.Roles;
import com.ecommerce.model.User;
import com.ecommerce.repo.RoleRepository;
import com.ecommerce.repo.UserRepository;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto) {
		
		//check if email is already registered
		if(userRepository.existsByEmail(registerDto.getEmail())) {
			return new ResponseEntity<>("Email is already registered", HttpStatus.BAD_REQUEST);
		}
		
		User user = new User();
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setEmail(registerDto.getEmail());
		user.setPhone(registerDto.getPhone());
		user.setPermissions(registerDto.getPermissions());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		
		Roles roles = roleRepository.findByRoleName("ROLE_ADMIN").get();
		user.setRoles(Collections.singleton(roles));
		
		userRepository.save(user);
		
		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getEmail(), loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User signed-in successfully", HttpStatus.OK);
	}
	
}
