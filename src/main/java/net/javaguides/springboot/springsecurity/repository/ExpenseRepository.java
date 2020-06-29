package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

}	
