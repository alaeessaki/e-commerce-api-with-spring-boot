package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.entities.PaymentType;

public interface PaymentTypeServiceInterface {

	public void add(PaymentType payment_type);
	public Optional<PaymentType> get(int id);
	public List<PaymentType> getAll();
	public void delete(int id);
	
}
