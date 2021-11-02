package com.model.data;
//**** return entity ny generic type or be method return diffirenet obj
import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

enum OrderType implements Serializable{
	BORROW,
	BUY
}

public class Order extends IdModifier implements Serializable{
	
	// static int increaseOrderId = 0;
    Customer customer ;
    Book book;
    int number;
    OrderType orderType;
    Date orderDate;

	public Order(Customer customer, Book book, String number) {
		super.setId();
		this.setNumber(number);
		this.setBook(book);
		this.setCustomer(customer);
		this.setOrderDate();
	}

	public Order(Customer customer, Book book) {
		super.setId();
		this.setNumber("1");
		this.setBook(book);
		this.setCustomer(customer);
		this.setOrderDate();
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

	public void setNumber(String number) {
		this.number = Integer.parseInt(""+ Check.isNumber(number));
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
