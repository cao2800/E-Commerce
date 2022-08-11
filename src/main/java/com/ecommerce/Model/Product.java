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
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String productName;
	private double productPrice;
	private int quantityOnHand;
	
	@ManyToOne
	@JoinColumn(name="ColorID")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private ProductCategory productCategory;
	
	@OneToMany(mappedBy= "user")
	private List<Orders> orders;

}
