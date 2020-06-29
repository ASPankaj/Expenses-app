package net.javaguides.springboot.springsecurity.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.springboot.springsecurity.model.Expense;
import net.javaguides.springboot.springsecurity.service.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Expense> expenses = expenseService.getAll();
		model.addAttribute("expenses", expenses);
		return "expenses";
	}
	
	@GetMapping("/getOne")
	@ResponseBody
	public Optional<Expense> getOne(Integer id) {
		return expenseService.getOne(id);
	}
	
	@PostMapping(value="/addNew")
	public String addNew(Expense expense) {
		expenseService.addNew(expense);
		System.out.println(expense);
		return "redirect:/expenses/getAll";
	}
	
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Expense expense) {
		expenseService.update(expense);
		return "redirect:/expenses/getAll";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		expenseService.delete(id);
		return "redirect:/expenses/getAll";
	}
}












