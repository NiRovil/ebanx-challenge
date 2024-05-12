package com.ebanx.projeto.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.web.server.ResponseStatusException;

public class AccountNotFoundException extends ResponseStatusException{
	
	// This entire exception handler is not necessary, but with this we can handle errors easily
	public AccountNotFoundException() {
		super(NOT_FOUND);
	}

}
