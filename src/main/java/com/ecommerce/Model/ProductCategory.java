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
@Table(name="productcategory")
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	private String categoryName;
	
	@OneToMany(mappedBy= "productcategory")
	private List<Product> product;
}
