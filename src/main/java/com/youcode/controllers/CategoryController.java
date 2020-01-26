package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.entities.Category;
import com.youcode.exceptions.NotFoundException;
import com.youcode.services.interfaces.CategoryServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	CategoryServiceInterface category_service;

	@GetMapping("")
	public ResponseEntity<List<Category>> getAll(){
		return ResponseEntity.ok(category_service.getAllParents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id")int id){
		Category category = category_service.get(id).orElseThrow(()->new NotFoundException("there is no category with this id"));
		return ResponseEntity.ok(category);
	}
	
	@PostMapping("")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		category.checkProperties();
		category_service.add(category);
		return ResponseEntity.ok(category);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Category> addSubCategory(@PathVariable("id")int id, @RequestBody Category sub_category){
		Category parent_category = category_service.get(id).orElseThrow(()->new NotFoundException("there is no category with this id"));
		sub_category.setParent(parent_category);
		sub_category.checkProperties();
		category_service.add(sub_category);
		return ResponseEntity.ok(sub_category);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> replaceCategory(@PathVariable("id")int id, @RequestBody Category new_category){
		category_service.get(id).orElseThrow(()->new NotFoundException("there is no category with this id"));
		new_category.setId(id);
		new_category.checkProperties();
		category_service.add(new_category);
		return ResponseEntity.ok(new_category);
	}
	
	
	@PatchMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id")int id, @RequestBody Category new_category){
		Category category = category_service.get(id).orElseThrow(()->new NotFoundException("there is no category with this id"));
		category.setLabel(new_category.getLabel());
		category_service.add(category);
		return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id")int id){
		category_service.get(id).orElseThrow(()->new NotFoundException("there is no category with this id"));
		category_service.delete(id);
		return ResponseEntity.ok("category deleted successfully");
	}
}
