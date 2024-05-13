package com.ebanx.projeto.entities;

public class Transaction {
	
	private Long transactionId;
	private Integer amount;
	private String type;
	private Long destination;
	private Long origin;
	
	public Transaction() {}

	public Transaction(Long transactionId, String type, Long destination, Integer amount, Long origin) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
		this.destination = destination;
		this.origin = origin;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getDestination() {
		return destination;
	}

	public void setDestination(Long destination) {
		this.destination = destination;
	}

	public Long getOrigin() {
		return origin;
	}

	public void setOrigin(Long origin) {
		this.origin = origin;
	}

}
