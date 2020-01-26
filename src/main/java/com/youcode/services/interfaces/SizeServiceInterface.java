package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.entities.Size;

public interface SizeServiceInterface {

	public void add(Size size);
	public Optional<Size> get(int id);
	public List<Size> getAll();
	public void delete(int id);
	
}
