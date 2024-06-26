package com.ebanx.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebanx.projeto.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
}
