package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.PieceType;

@Repository
public interface PieceTypeDaoInterface extends JpaRepository<PieceType, Integer>{

}
