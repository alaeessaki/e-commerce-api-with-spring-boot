package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.ShippingDaoInterface;
import com.youcode.entities.Shipping;
import com.youcode.services.interfaces.ShippingServiceInterface;

@Service
public class ShippingService implements ShippingServiceInterface{

	@Autowired
	ShippingDaoInterface shipping_dao;
	
	public void add(Shipping shipping) {
		shipping_dao.save(shipping);
	}
	public Optional<Shipping> get(int id){
		return shipping_dao.findById(id);
	}
	public List<Shipping> getAll(){
		return shipping_dao.findAll();
	}
	public void delete(int id) {
		shipping_dao.deleteById(id);
	}
}
