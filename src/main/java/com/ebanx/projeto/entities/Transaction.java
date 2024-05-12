package com.ebanx.projeto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transaction")
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long transactionId;
	
	@Column(nullable = false)
	private Integer amount;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private Long origin;
	private Long destination = 1L;
	
	public Transaction() {}

	public Transaction(Long transactionId, String type, Long origin, Integer amount) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
		this.origin = origin;
	}

	public Transaction(Long transactionId, String type, Long origin, Integer amount, Long destination) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
		this.origin = origin;
		this.destination = destination;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getOrigin() {
		return origin;
	}

	public void setOrigin(Long origin) {
		this.origin = origin;
	}

	public Long getDestination() {
		return destination;
	}

	public void setDestination(Long destination) {
		this.destination = destination;
	}
	
	
	
}
