package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.PaymentType;

@Repository
public interface PaymentTypeDaoInterface extends JpaRepository<PaymentType, Integer>{

}
