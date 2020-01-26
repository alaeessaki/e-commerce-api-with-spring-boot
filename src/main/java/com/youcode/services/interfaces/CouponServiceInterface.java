package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.entities.Coupon;

public interface CouponServiceInterface {

	public void add(Coupon coupon);
	public Optional<Coupon> get(int id);
	public List<Coupon> getAll();
	public void delete(int id);
	
}
