package com.ojas.mms.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ojas.mms.dao.LoginDAOImpl;





/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		LoginDAOImpl dao = new LoginDAOImpl();
		String type = dao.login(uname, pwd);
		System.out.println("HEllo Dashboard1");
		if(type.equals("admin")) {
			System.out.println("HEllo Dashboard");
			RequestDispatcher rd = request.getRequestDispatcher("./dashboard.html");
			rd.include(request, response);
		}else if(type.equals("vendor")){
			RequestDispatcher rd = request.getRequestDispatcher("./vendor.html");
			rd.include(request, response);
		}else if(type.equals("customer")){
			RequestDispatcher rd = request.getRequestDispatcher("./customer.html");
			rd.include(request, response);
		}else if(type.equals("")) {
			out.println("Invalid Username/password . please try again");
			RequestDispatcher rd = request.getRequestDispatcher("./signin.html");
			rd.include(request, response);
		}
	}

}
