package com.sg.poc.impl;

import java.util.List;

import com.sg.poc.domaine.Account;
import com.sg.poc.domaine.Operation;
import com.sg.poc.services.HistoryOperationService;

public class HistoryImpl implements HistoryOperationService {


	public List<Operation> getHistory(Account account){
		return account.getOperations();
	}

}
