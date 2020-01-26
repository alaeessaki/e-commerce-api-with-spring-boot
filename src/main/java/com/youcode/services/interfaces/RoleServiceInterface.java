package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.entities.Role;

public interface RoleServiceInterface {

	public void add(Role role);
	public Optional<Role> getRole(int id);
	public List<Role> getAll();
	public void delete(int id);
	
}
