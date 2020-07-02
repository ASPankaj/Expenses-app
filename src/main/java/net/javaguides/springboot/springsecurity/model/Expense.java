package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NamedQuery(name="Expense.findByDates",query="SELECT e from Expense e where e.date between ?1 and ?2")
public class Expense {
	
	@Id
	private Integer id;
	private String name;
	private String price;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String date;
	
	public Expense (){
		
	}
	
	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", price=" + price + ", date=" + date + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
 }
