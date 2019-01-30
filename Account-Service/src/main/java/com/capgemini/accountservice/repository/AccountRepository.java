package com.capgemini.accountservice.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.accountservice.app.entity.SavingsAccount;

@Repository
public interface AccountRepository extends  MongoRepository<SavingsAccount, Integer>{
	
}
