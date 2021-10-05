package com.model.data;

import java.sql.Date;

enum OrderType {
	BORROW,
	BUY
}

public class Order extends IdModifier {
	
	static int IncreaseOrderId = 0;
	
    Customer customer ;
    Book book ;
    int number;
    OrderType orderType ;
    Date orderDate;
    
    public Order(Customer customer, Book book) {
		IncreaseOrderId++;
		super.setId(IncreaseOrderId);
		this.setBook(book);
		this.setCustomer(customer); 
		this.setNumber(1);
		orderDate = new Date(new Now());
	}
	
	public Order(Customer customer, Book book, int number) {
		IncreaseOrderId++;
		super.setId(IncreaseOrderId);
		this.setBook(book);
		this.setCustomer(customer);
		
		this.setNumber(number);
	}



	public Customer getCustomer() {
		return customer;
	}
	

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public void setId(int id) {
		this.Id = id;
		
	}

}
