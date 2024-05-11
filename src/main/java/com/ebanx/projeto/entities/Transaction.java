package com.ebanx.projeto.entities;

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
	
}
