package com.ebanx.projeto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account {
	
	@Id
	private Long accountId;

	@Column(name = "balance")
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

	public void deposit(Integer value) {
		this.balance += value;
	}
	
	public void withdraw(Integer value) {
		this.balance -= value;
	}

}
