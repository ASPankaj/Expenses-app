package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DynamicUpdate
@DynamicInsert
@NamedQueries( value = {
		@NamedQuery(name= "Products.findByProductName", query="Select p from Products p where p.product_name=?1"),
		@NamedQuery(name= "Products.findByBrand", query="Select p from Products p where p.brand=?1"),
		@NamedQuery(name= "Products.findByProductNameAndBrand", query="Select p from Products p where p.product_name=?1 and p.brand=?2")
						}	
			 )
public class Products {

	@Id
	private Integer pid;
	private String product_name;
	private String price;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String manufacturing_date;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String expiry_date;
	private String brand;
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getManufacturing_date() {
		return manufacturing_date;
	}
	public void setManufacturing_date(String manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", product_name=" + product_name + ", price=" + price + ", manufacturing_date="
				+ manufacturing_date + ", expiry_date=" + expiry_date + ", brand=" + brand + "]";
	}
	
	
	
	
}
