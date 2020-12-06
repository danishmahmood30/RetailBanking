package com.service;

import com.dao.LoginDao;

public class LoginService {
	
	public int employeeLogin(String username,String password) {
		LoginDao ld = new LoginDao();
		int result = ld.verifyEmployee(username, password);
		return result;
	}
	
	public boolean customerLogin(String username,String password) {
		LoginDao ld = new LoginDao();
		boolean result = ld.verifyCustomer(username, password);
		return result;
	}
	
	
}
