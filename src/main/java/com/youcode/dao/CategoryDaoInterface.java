package com.youcode.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Category;

@Repository
public interface CategoryDaoInterface extends JpaRepository<Category, Integer>{
	public List<Category> findByParentIsNull();
}
