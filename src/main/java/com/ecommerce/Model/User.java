package com.ecommerce.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String permissions;
	
	@OneToMany(mappedBy= "user")
	private List<UserRoles> userRoles;
	
	@OneToMany(mappedBy= "user")
	private List<Payment> payment;
	
	@OneToMany(mappedBy= "user")
	private List<Address> address;
	
	@OneToMany(mappedBy= "user")
	private List<Orders> orders;
}
