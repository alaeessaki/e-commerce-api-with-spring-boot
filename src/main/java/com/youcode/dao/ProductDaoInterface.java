package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youcode.entities.Product;

public interface ProductDaoInterface extends JpaRepository<Product, Integer>{

}
