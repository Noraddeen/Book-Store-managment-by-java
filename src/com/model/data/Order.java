package com.model.data;
//**** return entity ny generic type or be method return diffirenet obj
import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;



public class Order extends IdModifier implements Serializable{
	
	// static int increaseOrderId = 0;
	String customerId ;
    String bookId;
    int number;
    Date orderDate;
	int session;

	public Order(String customer, String book, String number,int session) {
		super.setId();
		this.setNumber(number);
		this.setBook(book);
		this.setCustomer(customer);
		this.setOrderDate();
		this.session = session;
	}

	public Order(String customer, String book) {
		super.setId();
		this.setNumber("1");
		this.setBook(book);
		this.setCustomer(customer);
		this.setOrderDate();
	}

	public String getCustomer() {
		return customerId;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public void setCustomer(String customer) {
		this.customerId = customer;
	}

	public String getBook() {
		return bookId;
	}

	public void setBook(String book) {
		this.bookId = book;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(String number) {
		Double num = Check.isNumber(number);
		this.number = (int) Math.floor(num);
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate() {
		this.orderDate = new Date();
	}

	public void setOrderDate(Date date) {
		this.orderDate = date;
	}

}
