package com.service;

import com.bean.Customer;
import com.dao.CustomerDao;

public class CustomerService {
	public int addCustomer(Customer customer) {
		CustomerDao pd = new CustomerDao();
		int x=pd.addPatient(customer);
		return x;
	}
	
	public Customer searchPatient(int customertId) {
		CustomerDao cd = new CustomerDao();
		Customer c = cd.viewCustomer(customertId);
		return c;
	}
}
	
//	public ArrayList<Customer> viewAll() {
//		CustomerDao cd = new CustomerDao();
//		ArrayList<Customer> clist = cd.viewAll();
//		return clist;
//	}
//	
//	public int updatePatient(Customer patient, int customertId) throws SQLException {
//		CustomerDao cd = new CustomerDao();
//		return cd.updateCustomer(customer, customertId);
//	}
//	
//	public int deleteCustomer(int customertId) {
//		CustomerDao cd = new CustomerDao();
//		int x=cd.deleteCustomer(customertId);
//		return x;
//	}
//	
//	public int deleteCustomer(int ssnId, boolean confirmed) {
//		CustomerDao cd = new CustomerDao();
//		int x= cd.deleteCustomer(ssnId);
//		return x;
//	}
//	
//	public int dischargeCustomer(int customertId) {
//		CustomerDao cd = new CustomerDao();
//		int x= cd.dischargeCustomer(customertId);
//		return x;
//	}
//}
