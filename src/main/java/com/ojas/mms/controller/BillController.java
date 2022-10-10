package com.ojas.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.mms.dao.CustomerDaoImpl;
import com.ojas.mms.db.DBUtility;
import com.ojas.model.Movie;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/billcontroller")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int amount;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillController() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		System.out.println("bookticketcontroller");
		int bid1=Integer.parseInt(req.getParameter("bid"));
		int movieid1=Integer.parseInt(req.getParameter("movieid"));
		String movieName1=req.getParameter("moviename");
		String date1=req.getParameter("date");
		String showtime1=req.getParameter("showtime");
		int numoftickets1=Integer.parseInt(req.getParameter("numoftickets"));
		int seatnum1=Integer.parseInt(req.getParameter("seatnum"));
		CustomerDaoImpl cdo=new CustomerDaoImpl();
		Movie m=new Movie();

		
	 List<Movie> ml=new ArrayList<Movie>();

		//Movie m=new Movie();
		try {
		Connection con = DBUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from movie");
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			//m.setMovieid(rs.getInt(1));
			m.setMoviename(rs.getString(2));
			m.setTickets(rs.getInt(3));
			m.setPrice(rs.getInt(4));
			//int amount=rs.getInt(5);
			}
			m.getMoviename();
	int	totaltickets=	m.getTickets();
	if(numoftickets1<totaltickets){
		if(movieName1.contains(m.getMoviename()));
		
	out.println("tickets booked sucessfully "+"<br>");
			 amount=m.getPrice()*numoftickets1;
		
			int tickets2= totaltickets-numoftickets1;

 ps= con.prepareStatement("UPDATE movie SET tickets=? WHERE movieid=? ");
			 ps.setInt(1,tickets2 );
			 ps.setInt(2, movieid1);
			 ps.executeUpdate();
			 System.out.println("upadated");
	}	
	
	else {
		out.println("not booked");
	} 
	out.println("     acknowledgement"+"<br>");
	out.println("=============================="+"<br>");
	out.println("moviename              : "+m.getMoviename()+"<br>");
	out.println("price                  : "+m.getPrice()+"<br>");
	out.println("tickets                :"+numoftickets1+"<br>");
	out.println("============================="+"<br>");
    out.println("total amount            :"+amount+"<br>");
    out.println("==============================="+"<br>");
		}
		catch(Exception e) {
		System.out.println("error");
		}
}
}