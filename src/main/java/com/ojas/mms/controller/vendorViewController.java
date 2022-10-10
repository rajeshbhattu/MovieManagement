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
import com.ojas.model.Vendor;


/**
 * Servlet implementation class AdminViewController
 */
@WebServlet("/viewVender")
public class vendorViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vendorViewController() {
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
	
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		int venId=Integer.parseInt(request.getParameter("vid"));
		AdminVendorImpl ado=new AdminVendorImpl();
		Vendor v=ado.viewVendor(venId);
		out.println(v.getVid());
		out.println(v.getVendorName());
		out.println(v.getEmail());
		out.println(v.getAddress());
		//out.println("<a class=btn btn-primary href=./viewVender.html>Back</a>");
	//RequestDispatcher rd = request.getRequestDispatcher("./viewVender.html");
// rd.include(request, response);
		
		

	}

}
