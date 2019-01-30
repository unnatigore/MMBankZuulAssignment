package com.capgemini.accountservice.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.accountservice.app.entity.SavingsAccount;
import com.capgemini.accountservice.service.AccountService;

@RefreshScope
@RestController
@RequestMapping("/accounts")
public class AccountResource {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping
	public SavingsAccount addSavingsAccount(@RequestBody SavingsAccount savingsAccount) {
		return accountService.addSavingsAccount(savingsAccount);
	}
	
	@GetMapping
	public ResponseEntity<List<SavingsAccount>> getListOfAccounts(){
		List<SavingsAccount> accounts = accountService.getListOfAccounts();
		if(accounts == null) {
			return new ResponseEntity<>(accounts , HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(accounts , HttpStatus.OK);
	}
	
	@GetMapping("{accountId}")
	public ResponseEntity<SavingsAccount> getAccountById(@PathVariable int accountId) {
		SavingsAccount account = accountService.getAccountById(accountId);
		if (account == null) {
			return new ResponseEntity<>(account, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	
	@GetMapping("{accountId}/balance")
	public ResponseEntity<Double> getAccountBalanceById(@PathVariable int accountId) {
		SavingsAccount account = accountService.getAccountById(accountId);
		if (account == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(account.getCurrentBalance(), HttpStatus.OK);
	}
	
	@PutMapping("{accountId}")
	public void updateBalance(@PathVariable int accountId, @RequestParam("currentBalance") double currentBalance) {
		SavingsAccount savingsAccount = accountService.getAccountById(accountId);
		savingsAccount.setCurrentBalance(currentBalance);
		accountService.updateBalance(savingsAccount);
	}
	
	
}
