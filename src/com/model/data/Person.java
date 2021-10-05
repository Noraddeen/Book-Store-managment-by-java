package com.model.data;

public abstract class Person extends IdModifier {           // this class will not be instantiated. is for the same fuctions that maanger and customer have common
	
	
	
	String name;
	String adress;
	int phone;
	String email;
	char[] passWord;
	
	
	public Person(String name, String adress, int phone, String email, char[] passWord) throws Exception {
		
		setName(name);
		setAdress(adress);
		setPhone(phone);
		setEmail(email);
		setPassWord(passWord);
		
	}
	
	public String getName() {
		return name;
	}
	
	
	public static void setName(String name) throws Exception {
		if( name.matches(".*\\d+.*")) 
			throw new Exception("Please, no number in the name");
    }
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public char[] getPassWord() {
		return passWord;
	}
	
	public void setPassWord(char[] passWord) {
		this.passWord = passWord;
	}
	
	

}
