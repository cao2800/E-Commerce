package com.ecommerce.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="productcategory")
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CategoryID")
	private int categoryId;
	
	@Column(name="categoryname")
	private String categoryName;
	
	@OneToMany(fetch = FetchType.EAGER,  mappedBy= "productCategory", cascade = CascadeType.ALL)
	private Set<Product> productSet;
//	
//	public void addProduct(Product product) {
//		if(productSet == null) {
//			productSet = new HashSet<>();
//		}
//		product.productCategory = this;
//		productSet.add(product);
//	}
}
