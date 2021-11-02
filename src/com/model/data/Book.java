package com.model.data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;


public class Book extends IdModifier implements Serializable , Comparable {
	
	// static int increaseBookId = 0 ;
	String title ;
	String author ;
	String puplisher ;
	BookType bookType;
	int number ;
	double price ;
	double discount;
	
	public Book(){}
	
	public Book(String title,
				String author,
				String puplisher,
				String number,
				String price,
				BookType book_type) {
		super.setId();
		this.setTitle(title);
		this.setPuplisher(puplisher);
		this.setAuthor(author);
		this.setnumber(number);
		this.setprice(price);
		this.setBookType(book_type);
	}

	

	public Book(String title,
				String author,
				String puplisher,
				String number,
				String price,
				BookType book_type,
				String discount) {
	this(title, author, puplisher, number, price, book_type);
	setDiscount(discount);
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = Check.isNotNullString(title , "title");  // string accept number and symple but not null
	}
	
	public String getAuther() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = Check.isAlpha(author, "auther");
	}
	
	public String getPuplisher() {
		return puplisher;
	}
	
	public void setPuplisher(String puplisher){
		this.author = Check.isAlpha(puplisher, "puplisher");
	}

	public int getnumber() {
		return number;
	}

	public void setnumber(String number) {
		Double num = Check.isNumber(number);
		this.number = (int) Math.floor(num);
	}

	public double getprice() {
		return price;
	}
	
	public void setprice(String price) {
		this.price = Check.isNumber(price);
	}

	public double getDiscount() {
		return ofNullable(this.discount).orElse(0.0);

	}

	public void set(
			String title,
			String author,
			String puplisher,
			String number,
			String price,
			BookType book_type
	){
		this.setTitle(title);
		this.setPuplisher(puplisher);
		this.setAuthor(author);
		this.setnumber(number);
		this.setprice(price);
		this.setBookType(book_type);
	}

	public void setDiscount(String discount) {
		this.discount = Check.isNumber(discount);
	}

	public void setBookType(BookType book_type) {
		bookType = book_type;
	}

	public BookType getBooktype() {
		return bookType;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
