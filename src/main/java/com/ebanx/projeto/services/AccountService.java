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
		if (withdraw < acc.getBalance()) {
			acc.withdraw(withdraw);
			repository.save(acc);
		}
	}

}
