package net.javaguides.springboot.springsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Transactions;
import net.javaguides.springboot.springsecurity.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transactions> getAll() {
		return (List<Transactions>) transactionRepository.findAll();
	}
	
	public Optional<Transactions> getOne(Integer tid) {
		return transactionRepository.findById(tid);
	}
	
	public void addNew(Transactions transactions) {
		transactionRepository.save(transactions);
	}
	
	public void update(Transactions transactions) {
		transactionRepository.save(transactions);		
	}
	
	public void delete(Integer tid) {
		transactionRepository.deleteById(tid);
	}
	
	public List<Transactions> getBySender(String sender){
		return transactionRepository.getTransactionBySender(sender);
	}
	
	public List<Transactions> getById(Integer tid){
		return transactionRepository.getTransactionById(tid);
	}

	
}
