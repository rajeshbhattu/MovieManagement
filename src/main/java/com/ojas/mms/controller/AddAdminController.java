package com.ojas.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.mms.dao.AdminDaoImpl;
import com.ojas.mms.dao.AdminVendorImpl;

/**
 * Servlet implementation class AddAdminController
 */
@WebServlet("/addadmin")
public class AddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int  movieid = Integer.parseInt(request.getParameter("movieid"));
		String movieName = request.getParameter("moviename");
		int  ticket1 = Integer.parseInt(request.getParameter("tickets"));
		int price1 = Integer.parseInt(request.getParameter("price"));
		String date = request.getParameter("date");
		String showtime = request.getParameter("showtime");
		int seats1= Integer.parseInt(request.getParameter("seats"));
		System.out.println("controller");
		AdminDaoImpl adminDAO = new AdminDaoImpl();
		String message = adminDAO.addMovie(movieid,movieName,ticket1,price1,date,showtime, seats1);
		out.println(message);
		out.println("ok boss");
		RequestDispatcher rd = request.getRequestDispatcher("./addmovie.html");
		rd.include(request, response);
	
	
	}

}
