package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youcode.entities.Color;

public interface ColorDaoInterface extends JpaRepository<Color, Integer>{

}
