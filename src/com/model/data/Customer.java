package com.model.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Customer extends Person  {

    //static int increaseCustomerId = 0;


	public Customer(String name, String adress, String phone, String email, String passWord) throws Exception{
		
		super(name, adress, phone, email, passWord);
		super.setId();
	}
}
