package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.springsecurity.model.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
	
	 public List<Expense> findByDate(String date);
	 public List<Expense> findByName(String name);
	 public List<Expense> findByNameAndPrice(String name, String price);

	 public List<Expense> findByDates(String date1, String date2);

		/*
		 * @Query("select e from expense where lower(e.name)= LOWER(:name)") public
		 * List<Expense> find(@RequestParam("name") String name);
		 */
	
	
}	 