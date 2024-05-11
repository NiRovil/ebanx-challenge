package com.ebanx.projeto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "tb_account")
public class Account {
	
	@Id
	private Long accountId;
	
	@PositiveOrZero
	@Column(name = "account")
	private Integer balance;
	
	public Account() {}

	public Account(Long accountId, Integer balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public Integer getBalance() {
		return balance;
	}
	
	public Long getId() {
		return accountId;
	}

}
