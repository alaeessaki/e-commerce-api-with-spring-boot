package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.entities.Category;

public interface CategoryServiceInterface {

	public void add(Category category);
	public Optional<Category> get(int id);
	public List<Category> getAllParents();
	public List<Category> getAll();
	public void delete(int id);
	
}
