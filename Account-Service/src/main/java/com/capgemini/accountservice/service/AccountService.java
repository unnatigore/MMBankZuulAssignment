package com.capgemini.accountservice.service;

import java.util.List;

import com.capgemini.accountservice.app.entity.SavingsAccount;

public interface AccountService {

	SavingsAccount addSavingsAccount(SavingsAccount savingsAccount);

	List<SavingsAccount> getListOfAccounts();

	SavingsAccount getAccountById(int accountId);

	void updateBalance(SavingsAccount savingsAccount);
	
	

}
