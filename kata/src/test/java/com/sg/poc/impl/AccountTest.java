package com.sg.poc.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sg.poc.exceptions.NotEnoughAmountException;
import com.sg.poc.domaine.Account;
import com.sg.poc.exceptions.NegativeAmountException;

public class AccountTest {

	private Account account;
	private static DepositImpl depositImpl;
	private static WithDrawalImpl withDrawalImpl;
	private static HistoryImpl historyImpl;

	@BeforeAll
	static void  setUpBeforeClass() {
		depositImpl = new DepositImpl();
		withDrawalImpl = new WithDrawalImpl();
		historyImpl = new HistoryImpl();
	}

	@BeforeEach
	void setUp() {
		account = new Account();

	}

	@Test
	void depositAmount() throws NegativeAmountException {
		depositImpl.depositAmount(account, new BigDecimal(40));
		BigDecimal balance = account.getBalance();

		assertEquals(balance, new BigDecimal(40));

	}

	@Test
	void withDrawaltAmount() throws NegativeAmountException, NotEnoughAmountException {
		depositImpl.depositAmount(account, new BigDecimal(100));
		withDrawalImpl.withDrawalAmmount(account, new BigDecimal(30));
		BigDecimal balance = account.getBalance();
		assertEquals(balance, new BigDecimal(70));

	}

	@Test
	void getHistory() throws NegativeAmountException, NotEnoughAmountException {
		depositImpl.depositAmount(account, new BigDecimal(100));
		withDrawalImpl.withDrawalAmmount(account, new BigDecimal(30));
		int nb = historyImpl.getHistory(account).size();
		assertEquals(nb, 2);

	}

	@Test
	void negativeAmountException() {
		NegativeAmountException exception = assertThrows(NegativeAmountException.class, () -> {
			depositImpl.depositAmount(account, new BigDecimal(-40));
		});
		String expectedMessage = "Amount must be greater than ZERO";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void InsufficientAmountException() {
		NotEnoughAmountException exception = assertThrows(NotEnoughAmountException.class, () -> {
			withDrawalImpl.withDrawalAmmount(account, new BigDecimal(20));
		});
		String expectedMessage = "Your balance is insufficient to perform this operation";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
