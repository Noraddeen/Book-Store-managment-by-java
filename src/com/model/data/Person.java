package com.model.data;

// **** address and password

import java.io.Serializable;

public abstract class Person extends IdModifier implements Serializable{

	String name;
	String adress;
	String phone;
	String email;
	String passWord;

	public Person(String name, String adress, String phone, String email, String passWord) throws Exception {
		setName(name);
		setAdress(adress);
		setPhone(phone);
		setEmail(email);
		setPassWord(passWord);
	}
	
	public String getName(){
		return name;
	}
	
	
	public void setName(String name) throws Exception {
		this.name = this.name = Check.isAlpha(name, "name");    // many input valid need isalpha method so we need to determine it's type for beter messege
    }
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = Check.isValidPhoneNumer(phone);
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = Check.isValidEmail(email);
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
