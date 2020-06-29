package net.javaguides.springboot.springsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Expense;
import net.javaguides.springboot.springsecurity.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> getAll() {
		return (List<Expense>) expenseRepository.findAll();
	}
	
	public Optional<Expense> getOne(Integer id) {
		return expenseRepository.findById(id);
	}
	
	public void addNew(Expense expense) {
		expenseRepository.save(expense);
	}
	
	public void update(Expense expense) {
		expenseRepository.save(expense);		
	}
	
	public void delete(Integer id) {
		expenseRepository.deleteById(id);
	}
}
