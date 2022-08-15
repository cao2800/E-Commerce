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
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PaymentID")
	private int paymentId;
	
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	@Column(name="paymenttype")
	private String paymentType;
	private String provider;
	
	@Column(name="cardnumber")
	private int cardNumber;
	private String expiration;
	private int ccv;
}
