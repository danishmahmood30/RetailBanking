package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DbConnection;

public class LoginDao {
	
	public int verifyEmployee(String username, String password) {
		Connection con = DbConnection.getConnection();

		try {
			String query= "select * from userstore where username=? ";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(2).equals(password)){
					System.out.println("successful login");
					if(rs.getString(3).equals("executive")) {
						return 1;
					}else {
						return 2;
					}
				}else {
					System.out.println("login failed");
					return 0;
				}
			}else {
				System.out.println("login failed");
				return 0;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean verifyCustomer(String username, String password) {
		Connection con = DbConnection.getConnection();

		try {
			String query= "select password from customer_login where username=? ";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				if(rs.getString(1).equals(password)){
					System.out.println("successful login");
					return true;
				}else {
					System.out.println("login failed");
					return false;
				}
			}else {
				System.out.println("login failed");
				return false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
