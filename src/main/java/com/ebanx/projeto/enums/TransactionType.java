package com.ebanx.projeto.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
	TRANSFER, DEPOSIT, WITHDRAW;
	
	@JsonValue
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
