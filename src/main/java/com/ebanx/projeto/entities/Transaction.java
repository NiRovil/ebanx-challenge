package com.ebanx.projeto.entities;

import com.ebanx.projeto.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransactionType type;
	
	@Column(nullable = false)
	private Long originAccId;
	private Long destinationAccId = 1L;
	
	public Transaction() {}

	public Transaction(Long transactionId, Integer amount, TransactionType type, Long originAccId) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
		this.originAccId = originAccId;
	}

	public Transaction(Long transactionId, Integer amount, TransactionType type, Long originAccId, Long destinationAccId) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
		this.originAccId = originAccId;
		this.destinationAccId = destinationAccId;
	}
	
	
	
}
