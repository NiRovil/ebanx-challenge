package com.ebanx.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.ebanx.projeto.entities.Account;
import com.ebanx.projeto.exceptions.AccountNotFoundException;
import com.ebanx.projeto.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void deleteAll() {
		jdbcTemplate.execute("TRUNCATE TABLE tb_account");
	}
	
	public Boolean getInstance(Long id) {
		return repository.existsById(id);
	}
	
	public Integer getBalance(Long id) {
		Account acc = repository.findById(id).orElseThrow(AccountNotFoundException::new);;
		return acc.getBalance();
	}
	
	public void deposit(Long id, Integer deposit) {
		Account acc = repository.findById(id).get();
		acc.deposit(deposit);
		repository.save(acc);
	}
	
	public void withdraw(Long id, Integer withdraw){
		Account acc = repository.findById(id).get();
		
		if(acc.getBalance() < withdraw) {
			throw new IllegalArgumentException();
		}
		
		acc.withdraw(withdraw);
		repository.save(acc);
	}
	
	public void transfer(Long originId, Long destinationId, Integer transfer) {
		Account origin = repository.findById(originId).get();
		Account destination = repository.findById(destinationId).get();
		
		if(origin.getBalance() < transfer) {
			throw new IllegalArgumentException();
		}
		
		origin.withdraw(transfer);
		destination.deposit(transfer);
		
		repository.save(origin);
		repository.save(destination);
		
	}

}
