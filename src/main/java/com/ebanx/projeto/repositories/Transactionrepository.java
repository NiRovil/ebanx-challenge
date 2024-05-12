package com.ebanx.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebanx.projeto.entities.Transaction;

@Repository
public interface Transactionrepository extends JpaRepository<Transaction, Long>{

}
