package com.model.data;

public class Manager extends Person {
	
	// static int increaseManagerId = 0;
	
	public Manager(String name, String adress, String phone, String email, String passWord) throws Exception{
		
		super(name, adress, phone, email, passWord);
		super.setId();
	}

}
