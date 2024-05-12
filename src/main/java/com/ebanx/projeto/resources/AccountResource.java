package com.ebanx.projeto.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.projeto.services.AccountService;

@RestController
@RequestMapping(value = "/balance", method = RequestMethod.GET)
public class AccountResource {
	
	@Autowired
	private AccountService accService;
	
	@ResponseBody
	public Integer getBalance(@RequestParam("accont_id") Integer account_id) {

		Integer balance = accService.getBalance(accId);
		
	}
	
}
