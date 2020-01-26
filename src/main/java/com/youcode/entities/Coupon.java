package com.youcode.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.youcode.config.AuditModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "coupons")
public class Coupon extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupon_id")
	private int id;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "discount_percent", nullable = false)
	private float discount_percent;
	
	@Column(name = "status", columnDefinition = "boolean default false")
	private boolean status;
	
	@Column(name = "expiration_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date expiration_date;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "piece_id", nullable = true)
	private Piece piece;
	
	public void expire() {
		this.status = true;
	}
}
