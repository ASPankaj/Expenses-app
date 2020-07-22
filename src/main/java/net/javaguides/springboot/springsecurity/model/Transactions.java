package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NamedNativeQueries(value= {
		@NamedNativeQuery(name= "Transactions.getTransactionBySender", query="select * from transactions t where t.sender = ?1",resultClass = Transactions.class),
		@NamedNativeQuery(name= "Transactions.getTransactionById", query="select * from transactions t where t.tid = ?1",resultClass = Transactions.class)
})
public class Transactions {
	
	@Id
	private Integer tid;
	private Integer transaction_amount;
	private String sender;
	private String receiver;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String transaction_date;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(Integer transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	@Override
	public String toString() {
		return "Transactions [tid=" + tid + ", transaction_amount=" + transaction_amount + ", sender=" + sender
				+ ", receiver=" + receiver + ", transaction_date=" + transaction_date + "]";
	}

	
}
