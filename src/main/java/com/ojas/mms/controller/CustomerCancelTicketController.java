package com.ojas.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.mms.dao.CustomerDaoImpl;

/**
 * Servlet implementation class CustomerCancelTicketController
 */
@WebServlet("/cancelticket")
public class CustomerCancelTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCancelTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	int movieid=Integer.parseInt(request.getParameter("movieid"));
	CustomerDaoImpl cdao=new CustomerDaoImpl();
	
String msg=	cdao.cancelTickets(movieid);
out.println(msg);
	}

}
