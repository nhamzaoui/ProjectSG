package com.sg.poc.impl;

import java.math.BigDecimal;

import com.sg.poc.domaine.Account;
import com.sg.poc.exceptions.NegativeAmountException;
import com.sg.poc.exceptions.NotEnoughAmountException;
import com.sg.poc.services.WithDrawalService;

public class WithDrawalImpl implements WithDrawalService {

	public void withDrawalAmmount(Account account, BigDecimal amount)
			throws NegativeAmountException, NotEnoughAmountException {
		account.withDrawalAmmount(account, amount);

	}

}
