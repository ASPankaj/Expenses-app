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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	//tbadded http://localhost:8080/expenses/getName?name=Hosting
	@GetMapping("/getName")
	@ResponseBody
	public List<Expense> getName(@RequestParam String name) {
		return expenseService.byName(name);
	}
	
	//tbadded http://localhost:8080/expenses/getDate?date=2020-06-21
	@GetMapping(value="/getDate")	
	@ResponseBody
	public List<Expense> getDate(@RequestParam String date) {	  			
		 return expenseService.bydate(date);
	}
	
	//tbadded http://localhost:8080/expenses/
		@GetMapping("/getCustomName")
		@ResponseBody
		public List<Expense> getCustomName(@RequestParam String name) {
			return expenseService.byName(name);
		}
		
	//tbadded http://localhost:8080/expenses/getNamePrice?price=1000&name=Hosting
		@GetMapping("/getNamePrice")
		@ResponseBody
		public List<Expense> getNameAndPrice(@RequestParam String name, @RequestParam String price) {
			return expenseService.byNameAndPrice(name, price);
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
	
	@GetMapping(value="/calculate/first")
	public String dateQuery(@RequestParam String date1,@RequestParam String date2,Model model) {
		 List<Expense> bydate = expenseService.bydates(date1,date2);
		 float totalExpense = 0 ;
		 for (Expense expense : bydate) {
			  totalExpense += Float.parseFloat(expense.getPrice());
			 System.out.println("totalExpense is ======> "+totalExpense );
		}
			model.addAttribute("total", totalExpense);
			model.addAttribute("expenses", expenseService.bydates(date1,date2));
		return "calculate";
	}
	
	
	/*
	 * @GetMapping(value="/calculate") public String customCalcRename(Model model) {
	 * String date="2020-07-07";
	 * 
	 * List<Expense> bydate = expenseService.bydate(date); float totalExpense = 0 ;
	 * for (Expense expense : bydate) { totalExpense +=
	 * Float.parseFloat(expense.getPrice());
	 * System.out.println("totalExpense is ======> "+totalExpense ); }
	 * 
	 * 
	 * model.addAttribute("total", totalExpense); model.addAttribute("expenses",
	 * expenseService.bydate(date));
	 * 
	 * return "calculate"; }
	 */
	
	
	

	
	
	
} 

