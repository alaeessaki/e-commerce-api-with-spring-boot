package com.youcode.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AttributeOverride(name="user_id", column=@Column(name="admin_id"))
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "admins")
public class Admin extends User{

	
}
