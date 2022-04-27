package com.sg.poc.domaine;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.sg.poc.enums.OperationType;

public class Operation {
	private BigDecimal balance;
	private BigDecimal amount;
	private OperationType operationType;
	private LocalDate date;

	public Operation(BigDecimal amount, BigDecimal balance, OperationType operationType) {
		super();
		this.amount = amount;
		this.balance = balance;
		this.operationType = operationType;
		this.date = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Operation{" + "  operationType=" + operationType + ", date=" + date + ", amount=" + amount
				+ ", balance=" + balance + '}';
	}

	
}
