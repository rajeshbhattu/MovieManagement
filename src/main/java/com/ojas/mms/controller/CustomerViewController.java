package com.ojas.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.mms.dao.AdminVendorImpl;
import com.ojas.mms.dao.CustomerDaoImpl;
import com.ojas.model.Movie;
import com.ojas.model.Vendor;

/**
 * Servlet implementation class CustomerViewController
 */
@WebServlet("/viewController")
public class CustomerViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerViewController() {
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
		String movieName=request.getParameter("moviename");
		CustomerDaoImpl ado=new CustomerDaoImpl();
		Movie m=ado.viewMovie(movieName);
		out.println(m.getMovieid());
		out.println(m.getMoviename());
		out.println(m.getDate1());
		out.println(m.getPrice());
		out.println(m.getSeatnum());
		out.println(m.getNumoftickets());
		//out.println("<a class=btn btn-primary href=./viewVender.html>Back</a>");
	RequestDispatcher rd = request.getRequestDispatcher("./viewVender.html");
 rd.include(request, response);
	}

}
