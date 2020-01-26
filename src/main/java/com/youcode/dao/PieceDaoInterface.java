package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Piece;

@Repository
public interface PieceDaoInterface extends JpaRepository<Piece, Integer>{

}
