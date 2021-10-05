package com.model.data;

import java.util.List;


 enum BookType {
	
	HISTORIC,
	NOVEL,
	SCIENTIC,
	ACADEMIC,
	RILAGIN,
	PSYCHOLOJIST,
	CHILDREN,
	POLITIC,
	ECONIMIC
	
}

public class Book extends IdModifier{
	
	static int increaseBookId = 0 ;
	String title ;
	List<String> athers;
	String puplisher ;
	BookType bookType;
	int numbers ;
	double Price ;
	double discount;
	
	
	
	public Book(String title, List<String> athers, String puplisher, int numbers, double price, BookType book_type) {
		
		increaseBookId++;
		super.setId(increaseBookId);
		this.setPuplisher(puplisher);
		this.setAthers(athers);
		this.setDiscount(discount);
		this.setBookType(book_type);
	}

	

	public Book(String title, List<String> athers, String puplisher, int numbers, double price, double discount) {
		
		increaseBookId++;
		super.setId(increaseBookId);
		this.setTitle(title);
		this.setPuplisher(puplisher);
		this.setAthers(athers);
		this.setDiscount(discount);
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<String> getAthers() {
		return athers;
	}
	
	public void setAthers(List<String> athers) {
		this.athers = athers;
	}
	
	public String getPuplisher() {
		return puplisher;
	}
	
	public void setPuplisher(String puplisher) {
		this.puplisher = puplisher;
	}
	
	public int getNumbers() {
		return numbers;
	}
	
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double price) {
		Price = price;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	} 
	
	public void setBookType(BookType book_type) {
		bookType = book_type;
		
	}
	
	public BookType getBooktype() {
		return bookType;
	}
	
	

}
