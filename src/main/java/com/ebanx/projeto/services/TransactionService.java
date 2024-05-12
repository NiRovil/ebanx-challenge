package com.ebanx.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.ebanx.projeto.entities.Account;
import com.ebanx.projeto.entities.Transaction;
import com.ebanx.projeto.repositories.AccountRepository;
import com.ebanx.projeto.repositories.Transactionrepository;

@Service
public class TransactionService {
	
	@Autowired
	private Transactionrepository transactionRepo;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private AccountService accountService;
	
	public void firstDeposit(Transaction transaction) {
		transactionRepo.save(transaction);
		Long accId = transaction.getOrigin();
		Integer deposit = transaction.getAmount();
		accountRepo.save(new Account(accId, deposit));
	}

	public void deposit(Transaction transaction) {
		transactionRepo.save(transaction);
		Long accId = transaction.getOrigin();
		Integer deposit = transaction.getAmount();
		accountService.deposit(accId, deposit);
	}
	
}
