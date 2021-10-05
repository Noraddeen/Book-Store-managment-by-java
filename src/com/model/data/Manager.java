package com.model.data;

public class Manager extends Person {
	
	static int increaseManagerId = 0;
	
	public Manager(String name, String adress, int phone, String email, char[] passWord) throws Exception{
		
		super(name, adress, phone, email, passWord);   // initilize fileds those inherited by super class
		
		increaseManagerId++;
		
		super.setId(increaseManagerId);
	}

}
