package com.ebanx.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebanx.projeto.entities.Account;
import com.ebanx.projeto.exceptions.AccountNotFoundException;
import com.ebanx.projeto.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	public Integer getBalance(Long id) {
		Account acc = repository.findById(id).orElseThrow(AccountNotFoundException::new);;
		return acc.getBalance();
	}
	
}
