package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.util.DbConnection;

public class CustomerDao {
	
	public static int customerid=0;
	public int addCustomer(Customer customer ) {
		
		System.out.println("inside add customer");
		int x=0,customerId=0;
		Connection con = DbConnection.getConnection();
		System.out.println("connection ok!!");
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, customer.getAadhaar());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getAddress1());
			ps.setString(5, customer.getAddress2());
			ps.setString(6, customer.getCity());
			ps.setString(7, customer.getState());
			ps.setString(8, customer.getStatus());
			x= ps.executeUpdate();
			
			if(x>0) {
				System.out.println("customer addedd");
				String fetchPatientId = "select customerid from customer where aadhaar=?";
				PreparedStatement ps2 = con.prepareStatement(fetchPatientId);
				ps2.setLong(1, customer.getAadhaar());
				ResultSet rs = ps2.executeQuery();
				System.out.println("fetching customer id");
				if(rs.next()) {
					customerId=rs.getInt(1);
					System.out.println(customerId);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error in adding customer");
			e.printStackTrace();
		}
		
		return customerId;
	}
	
	public int updateCustomer(Customer customer, int customerId) {
		int x=0;
		Connection con = DbConnection.getConnection();
		String sql = "update customer set name=?, age=?, address1=?, address2=?, city=?, state=? where customerId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setInt(2, customer.getAge());
			ps.setString(3, customer.getAddress1());
			ps.setString(4, customer.getAddress2());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setInt(7, customerId);
			x= ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public Customer viewCustomer(int customerId) {
		
		Customer c = new Customer();
		Connection con = DbConnection.getConnection();
		String sql = "select * from customer where customerId=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c.setCustomerId(rs.getInt(1));
				c.setAadhaar(rs.getLong(2));
				c.setName(rs.getString(3));
				c.setAge(rs.getInt(4));
				c.setAddress1(rs.getString(5));
				c.setAddress2(rs.getString(6));
				c.setCity(rs.getString(7));
				c.setState(rs.getString(8));
			}else {
				System.out.println("no customer");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return c;
		}
		
		return c;
	}
	
	public ArrayList<Customer> viewAll() {
		
		ArrayList<Customer> clist = new ArrayList<Customer>();
		Connection con = DbConnection.getConnection();
		String sql = "select * from customer";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setAadhaar(rs.getLong(2));
				c.setName(rs.getString(3));
				c.setAge(rs.getInt(4));
				c.setAddress1(rs.getString(5));
				c.setAddress2(rs.getString(6));
				c.setCity(rs.getString(7));
				c.setState(rs.getString(8));
				clist.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clist;
	
	}
	
	public int deleteCustomer(int customerId) {
		int x=0;
		Connection con = DbConnection.getConnection();
		String sql = "delete from customer where customerId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, customerId);
			x=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public int changeStatus(int customerId,String status) {
		int x=0;
		Connection con = DbConnection.getConnection();
		String sql = "update customer set status=? where customerId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, customerId);
			x=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;	
	}
}
