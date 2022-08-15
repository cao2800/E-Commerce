package com.ecommerce.dto;

import lombok.Data;

@Data
public class RegisterDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String permissions;
}
