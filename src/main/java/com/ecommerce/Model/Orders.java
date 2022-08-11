package com.ecommerce.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product product;
	
	private String orderNumber;
	private double totalPrice;
	private int totalQuantity;
	
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="AddressID")
	private Address address;
	
	private String orderStatus;
}
