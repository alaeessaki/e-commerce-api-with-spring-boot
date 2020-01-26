package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Shipping;

@Repository
public interface ShippingDaoInterface extends JpaRepository<Shipping, Integer>{

}
