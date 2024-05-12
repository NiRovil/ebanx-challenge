package com.ebanx.projeto.resources;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.projeto.entities.Transaction;
import com.ebanx.projeto.services.AccountService;
import com.ebanx.projeto.services.TransactionService;

@RestController
@RequestMapping
public class TransactionResource {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AccountService accService;
	
	@PostMapping(value = "/event")
	public ResponseEntity<?> deposit(@RequestBody Transaction transaction) {
		
		Long accId = transaction.getOrigin();
		Boolean accountExist = accService.getInstance(accId);
		
		switch(transaction.getType()) {
			case "deposit":
				if (accountExist) {
					transactionService.deposit(transaction);
					return new ResponseEntity<>("Message", HttpStatus.CREATED);
				}
				
				transactionService.firstDeposit(transaction);
				return new ResponseEntity<>("Message", HttpStatus.CREATED);
				
			case "withdraw":
				if (accountExist) {
					transactionService.withdraw(transaction);
					return new ResponseEntity<>("Message", HttpStatus.CREATED);
				}
				
				return new ResponseEntity<>("Message", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Message", HttpStatus.METHOD_NOT_ALLOWED);
		
	}

}
