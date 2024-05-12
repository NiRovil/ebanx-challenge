package com.ebanx.projeto.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ebanx.projeto.services.AccountService;

@RestController
@RequestMapping
public class AccountResource {
	
	@Autowired
	private AccountService accService;
	
	@PostMapping(value = "/reset")
	public ResponseEntity<String> deleteAll(){
		accService.deleteAll();
		return ResponseEntity.ok("OK");
	}

	@GetMapping(value = "/balance")
	public ResponseEntity<?> getBalance(@RequestParam(value = "account_id") Integer account_id) {
		Long accId = Long.valueOf(account_id);
		Integer balance = accService.getBalance(accId);
		return new ResponseEntity<>(balance, HttpStatus.OK);
	}
	
}
