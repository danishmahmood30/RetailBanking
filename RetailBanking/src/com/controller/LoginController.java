package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.LoginService;
import com.util.SessionChecker;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		HttpSession session =request.getSession(false);
		
		if(action==null) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		if((!action.equals("login"))&&(!SessionChecker.isValidSession(session))) {
			request.setAttribute("errormessage","Invalid Session. Please login again");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		if(action.equals("login")) {
			
			String username=request.getParameter("username");
			String password =request.getParameter("password");
			String loginType = request.getParameter("loginType");
			
			LoginService l_service = new LoginService();
			
			if(loginType.equals("employee")) {
				int isValid=l_service.employeeLogin(username, password);
				
				if(isValid==1) {
					HttpSession newSession = request.getSession(true);
					RequestDispatcher rd = request.getRequestDispatcher("execHome.jsp");
					newSession.setAttribute("username",username );
					rd.forward(request, response);
				}else if(isValid==2) {
					HttpSession newSession = request.getSession(true);
					RequestDispatcher rd = request.getRequestDispatcher("cashHome.jsp");
					newSession.setAttribute("username",username );
					rd.forward(request, response);
				}
				else {
					System.out.println("login failed");
					request.setAttribute("loginerror", "*invalid credentials");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			
			else if(loginType.equals("customer")) {
				boolean isValid=l_service.customerLogin(username, password);
				if(isValid) {
					HttpSession newSession = request.getSession(true);
					RequestDispatcher rd = request.getRequestDispatcher("cusHome.jsp");
					newSession.setAttribute("username",username );
					rd.forward(request, response);
				}else {
					System.out.println("login failed");
					request.setAttribute("loginerror", "*invalid credentials");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
						
		
		if(action.equals("logout")) {
			session.invalidate();
			request.setAttribute("errormessage", "logged out successfully");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
	}
	}

}
