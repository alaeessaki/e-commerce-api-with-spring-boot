package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.entities.Product;
import com.youcode.entities.Review;
import com.youcode.exceptions.NotFoundException;
import com.youcode.services.interfaces.ProductServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/products")
public class ProductController {

	
	@Autowired
	ProductServiceInterface product_service;
	
	@GetMapping("")
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity.ok(product_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id")int id){
		Product product = product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/{id}/reviews")
	public ResponseEntity<List<Review>> getProductReviews(@PathVariable("id")int id){
		Product product = product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		return ResponseEntity.ok(product.getReviews());
	}

	@PostMapping("")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		product.checkAttributes();		
		product_service.add(product);		
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id")int id){
		product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		product.setId(id);
		product.checkAttributes();
		product_service.add(product);
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id")int id){
		product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		product_service.delete(id);
		return ResponseEntity.ok("product deleted successfully");
	}
	
}
