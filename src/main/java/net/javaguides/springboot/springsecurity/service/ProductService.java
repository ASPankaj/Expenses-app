package net.javaguides.springboot.springsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Expense;
import net.javaguides.springboot.springsecurity.model.Products;
import net.javaguides.springboot.springsecurity.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Products> getAll() {
		return (List<Products>) productRepository.findAll();
	}
	
	public Optional<Products> getOne(Integer pid) {
		return productRepository.findById(pid);
	}
	
	public void addNew(Products products) {
		productRepository.save(products);
	}
	
	public void update(Products products) {
		productRepository.save(products);		
	}
	
	public void delete(Integer pid) {
		productRepository.deleteById(pid);
	}
	
	public List<Products> byProductName(String product_name) {
		return productRepository.findByProductName(product_name);
	}
	
	public List<Products> byProductBrand(String brand) {
		return productRepository.findByBrand(brand);
	}
	
	public List<Products> byProductNameAndBrand(String product_name, String brand) {
		return productRepository.findByProductNameAndBrand(product_name,brand);
	}
}
