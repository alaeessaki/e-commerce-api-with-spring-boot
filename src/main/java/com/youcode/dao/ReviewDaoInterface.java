package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Review;

@Repository
public interface ReviewDaoInterface extends JpaRepository<Review, Integer>{

}
