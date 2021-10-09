package com.model.busnisses;

public interface Login {

	boolean checkLogin(String email, char[] password);
	void forgetPassword();
}
