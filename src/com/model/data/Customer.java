package com.model.data;

public class Customer extends Person {
	
    static int increaseCustomerId = 0;
    
    Map<String,double> bankCard;
    
	public Customer(String name, String adress, int phone, String email, char[] passWord) throws Exception{
		
		super(name, adress, phone, email, passWord);
		increaseCustomerId++;
		
		super.setId(increaseCustomerId);
		
	}
	
	public String getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(String creditCard) {
		//.
		//validate input
		//
		this.creditCard = creditCard;
	}
	
	

}
