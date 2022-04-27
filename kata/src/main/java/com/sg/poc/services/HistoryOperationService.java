package com.sg.poc.services;

import java.util.List;

import com.sg.poc.domaine.Account;
import com.sg.poc.domaine.Operation;

public interface HistoryOperationService {
	/**
	 * Retrieves all the history of operation for a specific account.
	 *
	 * @param account the account of operations to retrieve
	 * @return the Operation list of the requested account
	 */

	List<Operation> getHistory(Account account);
}
