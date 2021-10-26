package com.model.data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public class Book extends IdModifier implements Serializable , Comparable , Check {
	
	static int increaseBookId = 0 ;
	String title ;
	String author ;
	String puplisher ;
	BookType bookType;
	int numbers ;
	double Price ;
	double discount;
	
	
	
	public Book(String title,
				String author,
				String puplisher,
				String numbers,
				String price,
				BookType book_type) {
		increaseBookId++;
		super.setId(increaseBookId);
		this.setTitle(title);
		this.setPuplisher(puplisher);
		this.setAuthor(author);
		this.setNumbers(numbers);
		this.setPrice(price);
		this.setBookType(book_type);
	}

	

	public Book(String title,
				String author,
				String puplisher,
				String numbers,
				String price,
				BookType book_type,
				String discount) {
	this(title, author, puplisher, numbers, price, book_type);
	setDiscount(discount);
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = isNotNull(title , "title");
	}
	
	public String getAuther() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = isLetters(author, "auther");
	}
	
	public String getPuplisher() {
		return puplisher;
	}
	
	public void setPuplisher(String puplisher){
		this.author = isLetters(puplisher, "puplisher");
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = Optional.
				ofNullable(numbers).
				filter(t->isNumeric(t)).
				map(t->Integer.parseInt(t)).
				orElseThrow(()->new IllegalStateException("in field numbers be aware of not input exapt numbers"));
	}

	public double getPrice() {
		return Price;
	}
	
	public void setPrice(String price) {
		Price = Optional.
				ofNullable(price).
				filter(t->isNumeric(t)).
				map(t->Double.parseDouble(t)).
				orElseThrow(()->new IllegalStateException("in field price be aware of not input exapt numbers"));
	}

	public double getDiscount() {
		return Optional.
				ofNullable(this.discount).orElse(0.0);

	}

	public void setDiscount(String discount) {
		this.discount = Optional.
				ofNullable(discount).
				filter(t->isNumeric(t)).
				map(t->Double.parseDouble(t)).
				orElseThrow(()->new IllegalStateException("in field numbers be aware of not input exapt numbers"));
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
