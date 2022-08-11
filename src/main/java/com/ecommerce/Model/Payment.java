package com.ecommerce.Model;

import javax.persistence.Entity;
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
@Table(name="payment")
public class Payment {
	
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	private String paymentType;
	private String provider;
	private int cardNumber;
	private String expiration;
	private int ccv;
}
