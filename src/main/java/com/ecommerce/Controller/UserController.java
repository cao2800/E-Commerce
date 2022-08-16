package com.ecommerce.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.LoginDto;
import com.ecommerce.dto.RegisterDto;
import com.ecommerce.model.Color;
import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.model.Roles;
import com.ecommerce.model.User;
import com.ecommerce.repo.ProductRepository;
import com.ecommerce.repo.RoleRepository;
import com.ecommerce.repo.UserRepository;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
	private ProductService productService;
	
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
	
	@GetMapping("/admin/loadUsers")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User> loadUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/admin/addProduct")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void addProduct(@RequestBody Product product) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.getCategoryId();
		productCategory.getCategoryName();
		
		Color color = new Color();
		color.getColorId();
		color.getColorName();
		
		product.setColor(color);
		product.setProductCategory(productCategory);
		productService.addProduct(product);
	}
	
	@DeleteMapping("/admin/deleteProduct/{prodId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteProduct(@PathVariable Integer prodId) {
		productService.deleteProduct(prodId);
	}
	
	@PutMapping("/admin/updateProduct/{prodId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void updateProduct(@RequestBody Product prod, @PathVariable Integer prodId) {
		productService.updateProduct(prod, prodId);
	}
	
}
