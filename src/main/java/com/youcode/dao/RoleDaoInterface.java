package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.entities.Role;

@Repository
public interface RoleDaoInterface extends JpaRepository<Role, Integer>{

}
