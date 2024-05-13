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
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void deleteAll() {
		jdbcTemplate.execute("TRUNCATE TABLE tb_transaction");
	}
	
	public void firstDeposit(Transaction transaction) {
		Long accId = transaction.getOrigin();
		Integer deposit = transaction.getAmount();
		accountRepo.save(new Account(accId, deposit));
		transactionRepo.save(transaction);
	}

	public void deposit(Transaction transaction) {
		Long accId = transaction.getOrigin();
		Integer deposit = transaction.getAmount();
		accountService.deposit(accId, deposit);
		transactionRepo.save(transaction);
	}
	
	public void withdraw(Transaction transaction) {
		Long accId = transaction.getOrigin();
		Integer withdraw = transaction.getAmount();
		accountService.withdraw(accId, withdraw);
		transactionRepo.save(transaction);
	}
	
	public void transfer(Transaction transaction) {
		Long origin = transaction.getOrigin();
		Long destination = transaction.getDestination();
		Integer transfer = transaction.getAmount();
		accountService.transfer(origin, destination, transfer);
		transactionRepo.save(transaction);
	}
	
}
