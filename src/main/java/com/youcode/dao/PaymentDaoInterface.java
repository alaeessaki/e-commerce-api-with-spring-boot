package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Payment;

@Repository
public interface PaymentDaoInterface extends JpaRepository<Payment, Integer>{

}
