package com.sg.poc.services;

import java.math.BigDecimal;

import com.sg.poc.domaine.Account;
import com.sg.poc.exceptions.NegativeAmountException;
import com.sg.poc.exceptions.NotEnoughAmountException;

public interface WithDrawalService {
	/**
	 * Withdraws an amount to a specific account.
	 *
	 * @param account the account for which the operation is requested
	 * @param amount  the amount to withdraw
	 * @throws NegativeAmountException  if the amount to withdraw is negative
	 * @throws NotEnoughAmountException if the account doesn't have enough balance
	 *                                  for this operation
	 */

	void withDrawalAmmount(Account account, BigDecimal amount) throws NegativeAmountException, NotEnoughAmountException;
}
