package com.ebanx.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanx.projeto.repositories.AccountRepository;
import com.ebanx.projeto.repositories.Transactionrepository;

@Service
public class TransactionService {
	
	@Autowired
	private Transactionrepository transactionRepo;
	@Autowired
	private AccountRepository accountRepo;
	
	
	
}
