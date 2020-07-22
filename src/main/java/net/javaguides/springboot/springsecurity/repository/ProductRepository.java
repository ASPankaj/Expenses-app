package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.springsecurity.model.Products;

public interface ProductRepository  extends CrudRepository<Products, Integer>{
	
	List<Products> findByProductName(String product_name);
	List<Products> findByBrand(String brand);
	List<Products> findByProductNameAndBrand(String product_name, String brand);
}
