package com.capgemini.transactionservice.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.transactionservice.app.entity.Transaction;
import com.capgemini.transactionservice.repo.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	TransactionRepository repository;

	@Override
	public List<Transaction> listOfTransactions() {
		return repository.findAll();
	}


	@Override
	public double deposit(Integer accountNumber, Double amount, double currentBalance, String transactionType) {
		Transaction transaction = new Transaction();
		currentBalance = currentBalance+amount;
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionDetails("Amount Deposited");
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		transaction.setTransactionType(transactionType);
		transaction.setTransactionDate(LocalDateTime.now());
		repository.save(transaction);
		return currentBalance;
	}


	@Override
	public double withdraw(Integer accountNumber, Double amount, double currentBalance, String transactionType) {
		Transaction transaction = new Transaction();
		currentBalance = currentBalance-amount;
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionDetails("Amount withdrewed");
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		transaction.setTransactionType(transactionType);
		transaction.setTransactionDate(LocalDateTime.now());
		repository.save(transaction);
		return currentBalance;
	}

	
}
