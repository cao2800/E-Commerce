package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
	
	public void addProduct(Product prod) {
		productRepository.save(prod);
	}
	
	public boolean updateProduct(Product prod, Integer id) {
		Optional<Product> tempProd = productRepository.findById(id);
		boolean retVal = false;
		
		if(tempProd.isPresent()) {
			Product product = tempProd.get();
			product.setProductName(prod.getProductName());
			product.setProductPrice(prod.getProductPrice());
			product.setQuantityOnHand(prod.getQuantityOnHand());
			productRepository.save(product);
			retVal = true;
		}
		return retVal;
	}
}
