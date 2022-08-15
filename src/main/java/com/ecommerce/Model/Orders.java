package com.ecommerce.model;

import javax.persistence.Column;
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
	@Column(name="OrderID")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product product;
	
	@Column(name="ordernumber")
	private String ordernumber;
	
	@Column(name="totalprice")
	private double totalprice;
	
	@Column(name="totalquantity")
	private int totalquantity;
	
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="AddressID")
	private Address address;
	
	@Column(name="orderstatus")
	private String orderstatus;
}
