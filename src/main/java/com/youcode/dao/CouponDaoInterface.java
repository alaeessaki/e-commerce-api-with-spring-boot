package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Coupon;

@Repository
public interface CouponDaoInterface extends JpaRepository<Coupon, Integer>{
	
}
