
package com.capgemini.accountservice.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.accountservice.app.entity.SavingsAccount;
import com.capgemini.accountservice.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		 return savingsAccount = accountRepository.save(savingsAccount);
	}

	@Override
	public List<SavingsAccount> getListOfAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public SavingsAccount getAccountById(int accountId) {
		return accountRepository.findById(accountId).get();
	}

	@Override
	public void updateBalance(SavingsAccount savingsAccount) {
		accountRepository.save(savingsAccount);
	}

}
