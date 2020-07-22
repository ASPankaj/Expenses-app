package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.springsecurity.model.Transactions;


public interface TransactionRepository extends CrudRepository<Transactions, Integer> {

	List<Transactions> getTransactionBySender(String sender);
	List<Transactions> getTransactionById(Integer tid);
}
