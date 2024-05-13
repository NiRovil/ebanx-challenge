package com.ebanx.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.ebanx.projeto.entities.Account;
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
		Account acc = repository.findById(id).get();
		return acc.getBalance();
	}
	
	public void firstDeposit(Long id, Integer deposit) {
		repository.save(new Account(id, deposit));
	}
	
	public void deposit(Long id, Integer deposit) {
		Account acc = repository.findById(id).get();
		acc.deposit(deposit);
		repository.save(acc);
	}
	
	public void withdraw(Long originId, Integer withdraw){
		Account origin = repository.findById(originId).get();
		origin.withdraw(withdraw);
		repository.save(origin);
	}
	
	public void transfer(Long destinationId, Long originId, Integer transfer) {
		
		Boolean destinationExist = getInstance(destinationId);
		Account origin = repository.findById(originId).get();
		
		if(destinationExist) {
			Account destination = repository.findById(destinationId).get();
			destination.withdraw(transfer);
			origin.deposit(transfer);
			repository.save(destination);
			repository.save(origin);
		}
		
		firstDeposit(destinationId, transfer);
		origin.withdraw(transfer);
		
		repository.save(origin);

	}

}
