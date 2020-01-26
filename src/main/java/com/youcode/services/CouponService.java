package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.CouponDaoInterface;
import com.youcode.entities.Coupon;
import com.youcode.services.interfaces.CouponServiceInterface;

@Service
public class CouponService implements CouponServiceInterface{
	
	@Autowired
	CouponDaoInterface coupon_dao;

	public void add(Coupon coupon) {
		coupon_dao.save(coupon);
	}
	
	public Optional<Coupon> get(int id){
		return coupon_dao.findById(id);
	}
	
	public List<Coupon> getAll(){
		return coupon_dao.findAll();
	}
	
	public void delete(int id) {
		coupon_dao.deleteById(id);
	}
}
