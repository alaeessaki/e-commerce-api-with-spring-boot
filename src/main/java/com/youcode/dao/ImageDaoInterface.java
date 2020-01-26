package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Image;

@Repository
public interface ImageDaoInterface extends JpaRepository<Image, Integer>{

}
