package com.ebanx.projeto.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.projeto.services.AccountService;

@RestController
@RequestMapping
public class AccountResource {
	
	@Autowired
	private AccountService accService;

	@GetMapping(value = "/balance")
	public ResponseEntity<Integer> getBalance(@RequestParam(value = "account_id") Integer account_id) {
		Long accId = Long.valueOf(account_id);
		Integer balance = accService.getBalance(accId);
		return ResponseEntity.ok(balance);
	}
	
}