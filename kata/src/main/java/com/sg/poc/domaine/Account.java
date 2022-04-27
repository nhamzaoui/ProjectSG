package com.sg.poc.domaine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sg.poc.enums.OperationType;
import com.sg.poc.exceptions.NegativeAmountException;
import com.sg.poc.exceptions.NotEnoughAmountException;

public class Account {
	private BigDecimal balance;

	private List<Operation> operations;

	public Account() {
		this.balance = BigDecimal.ZERO;
		this.operations = new ArrayList<Operation>();
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void depositAmount(Account account, BigDecimal amount) throws NegativeAmountException {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new NegativeAmountException("Amount must be greater than ZERO");
		}
		this.balance = this.balance.add(amount);
		addOperation(new Operation(amount, this.balance, OperationType.DEPOSIT));

	}

	public void withDrawalAmmount(Account account, BigDecimal amount)
			throws NegativeAmountException, NotEnoughAmountException {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new NegativeAmountException("Amount must be greater than ZERO");
		} else if (this.balance.compareTo(amount) < 0) {
			throw new NotEnoughAmountException("Your balance is insufficient to perform this operation");
		}
		this.balance = this.balance.subtract(amount);
		addOperation(new Operation(amount, this.balance, OperationType.WITHDRAWAL));

	}

	private void addOperation(Operation operation) {
		this.operations.add(operation);
	}

}
