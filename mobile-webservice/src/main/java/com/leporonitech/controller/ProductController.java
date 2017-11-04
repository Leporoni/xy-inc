package com.leporonitech.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leporonitech.model.Product;
import com.leporonitech.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Product>> findAllProducts() {

		Collection<Product> productsFound = productService.findAllProducts();
		return new ResponseEntity<>(productsFound, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> searchProductForId(@PathVariable Integer id) {

		Product productsFound = productService.searchProductForId(id);
		return new ResponseEntity<>(productsFound, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> productRegistration(@RequestBody Product Product) {

		Product registeredProduct = productService.register(Product);
		return new ResponseEntity<>(registeredProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> changeProduct(@RequestBody Product Product) {

		Product ProductChanged = productService.register(Product);
		return new ResponseEntity<>(ProductChanged, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {

		Product productFound = productService.searchProductForId(id);
		if (productFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		productService.deleteProduct(productFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
