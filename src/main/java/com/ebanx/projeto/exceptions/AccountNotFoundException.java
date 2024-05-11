package com.ebanx.projeto.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.web.server.ResponseStatusException;

public class AccountNotFoundException extends ResponseStatusException{
	
	public AccountNotFoundException() {
		super(NOT_FOUND);
	}

}
