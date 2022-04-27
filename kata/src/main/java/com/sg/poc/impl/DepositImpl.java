package com.sg.poc.impl;

import java.math.BigDecimal;

import com.sg.poc.domaine.Account;
import com.sg.poc.exceptions.NegativeAmountException;
import com.sg.poc.services.DepositeService;

public class DepositImpl implements DepositeService {

	public void depositAmount(Account account, BigDecimal amount) throws NegativeAmountException {
		account.depositAmount(account, amount);

	}

}
