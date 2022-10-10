package com.ojas.mms.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.mms.dao.AdminVendorDao;
import com.ojas.mms.dao.AdminVendorImpl;

/**
 * Servlet implementation class AddAdminVendorController
 */
@WebServlet("/addVendor")
public class AddAdminVendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminVendorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String vendorName = request.getParameter("vname");
		String vendorEmail = request.getParameter("email");
		String address = request.getParameter("address");
		AdminVendorImpl adminDAO = new AdminVendorImpl();
		String message = adminDAO.addVendor(vendorName, vendorEmail, address);
		out.println(message);
		out.println("ok boss");
		RequestDispatcher rd = request.getRequestDispatcher("./addvendor.html");
		rd.include(request, response);
	}

}
