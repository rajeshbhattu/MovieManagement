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

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdatevendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatevendorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		int vendor_Id = Integer.parseInt(request.getParameter("vid"));
		String vendorName = request.getParameter("vname");
		String vendorEmail = request.getParameter("email");
		out.println("world");
		String address = request.getParameter("address");

		AdminVendorImpl adminDAO = new AdminVendorImpl();
		String msg=adminDAO.update( vendor_Id, vendorName, vendorEmail, address);
	out.println(msg);
		RequestDispatcher rd = request.getRequestDispatcher("./update.html");
		rd.include(request, response);
	}
		
	}


