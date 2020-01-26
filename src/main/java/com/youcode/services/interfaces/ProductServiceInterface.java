package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.entities.Product;

public interface ProductServiceInterface {

	public void add(Product product);
	public Optional<Product> get(int id);
	public List<Product> getAll();
	public void delete(int id);
	
}
