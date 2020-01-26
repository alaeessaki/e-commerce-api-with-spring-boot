package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.ProductDaoInterface;
import com.youcode.entities.Product;
import com.youcode.services.interfaces.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface{

	@Autowired
	ProductDaoInterface product_dao;
	
	public void add(Product product) {
		product_dao.save(product);
	}
	
	public Optional<Product> get(int id){
		return product_dao.findById(id);
	}
	
	public List<Product> getAll(){
		return product_dao.findAll();
	}
	
	public void delete(int id) {
		product_dao.deleteById(id);
	}
}
