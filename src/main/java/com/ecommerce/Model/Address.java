package com.ecommerce.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	private String street;
	private String unit;
	private String city;
	private String state;
	private int zipCode;
	private String country;
	private String phoneNo;
	
	@OneToMany(mappedBy= "address")
	private List<Orders> orders;
}
