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

import net.javaguides.springboot.springsecurity.model.Transactions;
import net.javaguides.springboot.springsecurity.service.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Transactions> transactions = transactionService.getAll();
		model.addAttribute("transactions", transactions);
		return "transactions";
	}
	
	@GetMapping("/getOne")
	@ResponseBody
	public Optional<Transactions> getOne(Integer tid) {
		return transactionService.getOne(tid);
	}	
	
	@PostMapping(value="/addNew")
	public String addNew(Transactions transactions) {
		transactionService.addNew(transactions);
		System.out.println(transactions);
		return "redirect:/transactions/getAll";
	}
	
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Transactions transactions) {
		transactionService.update(transactions);
		return "redirect:/transactions/getAll";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer tid) {
		transactionService.delete(tid);
		return "redirect:/transactions/getAll";
	}
	
	@RequestMapping("/getSource")
	public String getSender(@RequestParam String sender, Model model) {
		List<Transactions> transactions = transactionService.getBySender(sender);
		model.addAttribute("transactions", transactions);
		return "transactions";
	}
	
	
	@RequestMapping("/getbyId")
	public String getTrnsactionById(@RequestParam Integer tid, Model model) {
		List<Transactions> transactions = transactionService.getById(tid);
		model.addAttribute("transactions", transactions);
		return "transactions";
	}
}
