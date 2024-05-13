package com.ebanx.projeto.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ebanx.projeto.services.AccountService;
import com.fasterxml.jackson.databind.JsonNode;

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
		if(accService.getInstance(accId)) {
			Integer balance = accService.getBalance(accId);
			return ResponseEntity.ok(balance);
		}
		return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/event")
	public ResponseEntity<?> transaction(@RequestBody JsonNode transaction) {
		
		String type = transaction.path("type").asText();
		Long origin = transaction.path("origin").asLong();
		Long destination = transaction.path("destination").asLong();
		Integer amount = transaction.path("amount").asInt();
		
		Boolean destinationExist = accService.getInstance(destination);
		Boolean originExist = accService.getInstance(origin);
		
		switch(type) {
			case("deposit"):
				if (destinationExist) {
					accService.deposit(destination, amount);
					return new ResponseEntity<>("{\"destination\": {\"id\":\""+ destination +"\", \"balance\":"+ accService.getBalance(destination) +"}}", HttpStatus.CREATED);
				}
				accService.firstDeposit(destination, amount);
				return new ResponseEntity<>("{\"destination\": {\"id\":\""+ destination +"\", \"balance\":"+ accService.getBalance(destination) +"}}", HttpStatus.CREATED);
			case("withdraw"):
				if (originExist) {
					accService.withdraw(origin, amount);
					return new ResponseEntity<>("{\"origin\": {\"id\":\""+ origin +"\", \"balance\":"+ accService.getBalance(origin) +"}}", HttpStatus.CREATED);
				}
				return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
			case("transfer"):
				if (originExist) {
					accService.transfer(destination, origin, amount);
					return new ResponseEntity<>("{\"origin\": {\"id\":\""+ origin +"\", \"balance\":"+ accService.getBalance(origin) +"}, \"destination\": {\"id\":\""+ destination +"\", \"balance\":"+ accService.getBalance(destination) +"}}", HttpStatus.CREATED);
				}
				return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Message", HttpStatus.METHOD_NOT_ALLOWED);
	}
}
