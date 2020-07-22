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
import net.javaguides.springboot.springsecurity.model.Products;
import net.javaguides.springboot.springsecurity.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Products> products = productService.getAll();
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/getOne")
	@ResponseBody
	public Optional<Products> getOne(Integer pid) {
		return productService.getOne(pid);
	}	
	
	@PostMapping(value="/addNew")
	public String addNew(Products products) {
		productService.addNew(products);
		System.out.println(products);
		return "redirect:/products/getAll";
	}
	
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Products products) {
		productService.update(products);
		return "redirect:/products/getAll";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer pid) {
		productService.delete(pid);
		return "redirect:/products/getAll";
	}
	
	@RequestMapping(value = "/search", params = "product_name")
	public String getProductName(@RequestParam String product_name,Model model) {
		model.addAttribute("products", productService.byProductName(product_name));
		return "products";
	}
	
	@RequestMapping(value ="/search", params = "brand")
	public String getBrand(@RequestParam String brand,Model model) {
		model.addAttribute("products", productService.byProductBrand(brand));
		return "products";
	}
	
	
	
	/*
	 * //tbadded http://localhost:8080/expenses/getName?name=Hosting
	 * 
	 * @GetMapping("/getName")
	 * 
	 * @ResponseBody public List<Expense> getName(@RequestParam String name) {
	 * return productService.byName(name); }
	 * 
	 * //tbadded http://localhost:8080/expenses/getDate?date=2020-06-21
	 * 
	 * @GetMapping(value="/getDate")
	 * 
	 * @ResponseBody public List<Expense> getDate(@RequestParam String date) {
	 * return productService.bydate(date); }
	 * 
	 * //tbadded http://localhost:8080/expenses/
	 * 
	 * @GetMapping("/getCustomName")
	 * 
	 * @ResponseBody public List<Expense> getCustomName(@RequestParam String name) {
	 * return productService.byName(name); }
	 * 
	 * //tbadded http://localhost:8080/expenses/getNamePrice?price=1000&name=Hosting
	 * 
	 * @GetMapping("/getNamePrice")
	 * 
	 * @ResponseBody public List<Expense> getNameAndPrice(@RequestParam String
	 * name, @RequestParam String price) { return
	 * productService.byNameAndPrice(name, price); }
	 */
	
	
	/*
	 * @GetMapping(value="/calculate/first") public String dateQuery(@RequestParam
	 * String date1,@RequestParam String date2,Model model) { List<Expense> bydate =
	 * productService.bydates(date1,date2); float totalExpense = 0 ; for (Expense
	 * expense : bydate) { totalExpense += Float.parseFloat(expense.getPrice());
	 * System.out.println("totalExpense is ======> "+totalExpense ); }
	 * model.addAttribute("total", totalExpense); model.addAttribute("expenses",
	 * expenseService.bydates(date1,date2)); return "calculate"; }
	 */
}
