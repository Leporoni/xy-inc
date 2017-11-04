package com.leporonitech.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leporonitech.model.Product;
import com.leporonitech.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	// Business
	public Product register(Product product) {

		return productRepository.save(product);
	}

	public Collection<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	public Product searchProductForId(Integer id) {
		return productRepository.findOne(id);
	}

	public Product changeProduct(Product product) {

		return productRepository.save(product);
	}
}
