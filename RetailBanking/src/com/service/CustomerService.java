package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.dao.CustomerDao;

public class CustomerService {
	public int addCustomer(Customer customer) {
		CustomerDao cd = new CustomerDao();
		int x=cd.addCustomer(customer);
		return x;
	}
	
	public Customer searchPatient(int customertId) {
		CustomerDao cd = new CustomerDao();
		Customer c = cd.viewCustomer(customertId);
		return c;
	}

	
	public ArrayList<Customer> viewAll() {
		CustomerDao cd = new CustomerDao();
		ArrayList<Customer> clist = cd.viewAll();
		return clist;
	}
	
	
	public int updateCustomer(Customer customer, int customertId) throws SQLException {
		CustomerDao cd = new CustomerDao();
		return cd.updateCustomer(customer, customertId);
	}
	
	public int deleteCustomer(int customertId) {
		CustomerDao cd = new CustomerDao();
		int x=cd.deleteCustomer(customertId);
		return x;
	}
//	
//	public int deleteCustomer(int ssnId, boolean confirmed) {
//		CustomerDao cd = new CustomerDao();
//		int x= cd.deleteCustomer(ssnId);
//		return x;
//	}
//	
	public int changeStatus(int customertId, String status) {
		CustomerDao cd = new CustomerDao();
		int x= cd.changeStatus(customertId, status);
		return x;
	}
}
