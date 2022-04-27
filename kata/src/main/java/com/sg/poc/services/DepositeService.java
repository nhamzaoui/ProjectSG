package com.sg.poc.services;

import java.math.BigDecimal;

import com.sg.poc.domaine.Account;
import com.sg.poc.exceptions.NegativeAmountException;

public interface DepositeService {
	/**
	 * 
	 * Deposits an amount to a specific account.
	 *
	 * @param account the account for which the operation is requested
	 * @param amount  the amount must be deposited
	 * @throws NegativeAmountException if the amount to deposit is negative
	 */

	void depositAmount(Account account, BigDecimal amount) throws NegativeAmountException;
}
