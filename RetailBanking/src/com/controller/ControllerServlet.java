package com.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.service.CustomerService;

/**
 * Servlet implementation class CotrollerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ControllerServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("hiiiiiiiiiiiiiiii");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerService cs = new CustomerService();
		Customer customer = new Customer(673737483844L,"Rahul Kumar",43,"hishids","shdhsi","jdskjd","dsjdis");
//		cs.addCustomer(customer);
		CustomerDao cd = new CustomerDao();
//		ArrayList<Customer> clist= cd.viewAll();
//		for(Customer c:clist) {
//			System.out.println(c);
//		}
//		System.out.println(cd.viewCustomer(100493035));
//		cd.updatePatient(customer, 100493036) ;
		cd.deleteCustomer(100493036);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("hiiiiiiiiiiiiiiii Post");
	}

}
