package com.capgemini.transactionservice.service;

import java.util.List;

import com.capgemini.transactionservice.app.entity.Transaction;

public interface TransactionService {

	double deposit(Integer accountNumber, Double amount, double currentBalance, String deposit);

	double withdraw(Integer accountNumber, Double amount, double currentBalance, String withdraw);

	List<Transaction> listOfTransactions();
}
