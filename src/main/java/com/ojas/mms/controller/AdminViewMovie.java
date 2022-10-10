package com.ojas.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.mms.dao.AdminDaoImpl;
import com.ojas.model.Movie;
import com.ojas.model.Vendor;

/**
 * Servlet implementation class AdminViewMovie
 */
@WebServlet("/adminviewmovie")
public class AdminViewMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		System.out.println("hello");
		int movieid=Integer.parseInt(request.getParameter("movieid"));
		AdminDaoImpl ado=new AdminDaoImpl();
		Movie m=ado.viewMovie(movieid);
		out.println(m.getMovieid()+"<br>");
		out.println(m.getMoviename()+"<br>");
		out.println(m.getTickets()+"<br>");
		out.println(m.getPrice()+"<br>");
		out.println(m.getDate1()+"<br>");
		out.println(m.getShowtime()+"<br>");
		
	}

}
