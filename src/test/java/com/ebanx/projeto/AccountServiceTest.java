package com.ebanx.projeto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ebanx.projeto.services.AccountService;

@SpringBootTest
public class AccountServiceTest {
	
	@Autowired
	AccountService accountService;
	
	@Test
	public void accountServiceNonExistingAccount() {
		Long accId = 1234L;
		assertThrows(RuntimeException.class, () -> accountService.getBalance(accId));
	}
	
}
