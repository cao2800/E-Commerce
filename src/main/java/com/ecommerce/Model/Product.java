package com.ecommerce.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name="ProductID")
	private int productId;
	
	@Column(name="ProductName")
	private String productName;
	
	@Column(name="ProductPrice")
	private double productPrice;
	
	@Column(name="QuantityOnHand")
	private int quantityOnHand;
	
//	@Column(name="Color")
//	private String color;
	
	
//	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name="color", 
//	joinColumns = @JoinColumn(name = "ProductID", referencedColumnName="ProductID"),
//	inverseJoinColumns = @JoinColumn(name="ColorID", referencedColumnName="ColorID"))
//	private Set<Color> color;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="ColorID", referencedColumnName="ColorID", nullable = false )
	private Color color;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="CategoryID", referencedColumnName="CategoryID", nullable = false)
	private ProductCategory productCategory;
	
	@OneToMany(mappedBy= "product")
	private List<Orders> orders;
	

}


