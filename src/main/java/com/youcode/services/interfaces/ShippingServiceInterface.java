package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.entities.Shipping;

public interface ShippingServiceInterface {

	public void add(Shipping shipping);
	public Optional<Shipping> get(int id);
	public List<Shipping> getAll();
	public void delete(int id);
	
}
