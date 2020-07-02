package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
	
	 public List<Expense> findByDate(String from);
	
	 public List<Expense> findByDates(String date1, String date2);

}	 