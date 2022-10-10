package com.ojas.mms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.ojas.mms.db.DBUtility;
import com.ojas.model.Movie;
import com.ojas.model.Vendor;


public class AdminDaoImpl {
	public String addMovie(int movieid,String moviename,int tickets,int price,String date,String showtime,int seats)
	{
	Movie m=new Movie();
		
	String msg = "";
	try {
		Connection con = DBUtility.getConnection();
		System.out.println("addvendor1");
		PreparedStatement ps = con.prepareStatement("INSERT INTO Movie(moviename,tickets,price,date,showtime,seats) VALUES(?,?,?,?,?,?)");
		ps.setString(1,moviename);
		ps.setInt(2, tickets);
	ps.setInt(3, price);
ps.setString(4,date);
ps.setString(5,showtime);
ps.setInt(6, seats);

		int n = ps.executeUpdate();
		
		if(n!=0) {
			msg = "Successfully Vendror added......";
		}else {
			msg = "Notable to added.Please try again...";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return msg;
}



	public Movie viewMovie(int movieid) {
	Movie m=new Movie();
	try {
	Connection con = DBUtility.getConnection();
	PreparedStatement ps = con.prepareStatement("select * from movie where movieid=?");
	ps.setInt(1,movieid);

	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
	m.setMovieid(rs.getInt(1));
	m.setMoviename(rs.getString(2));
	m.setTickets(rs.getInt(3));
	m.setPrice(rs.getInt(4));
	m.setDate1(rs.getString(5));
	m.setShowtime(rs.getString(6));
	//m.setSeats(rs.getInt(7));


	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return m;
	}




	public List<Movie> viewAllMovie()
	{
	List<Movie> movie=new ArrayList<Movie>();
	Movie m=new Movie();
	try {
	Connection con = DBUtility.getConnection();
	PreparedStatement ps = con.prepareStatement("select * from movie ");


	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		m.setMovieid(rs.getInt(1));
		m.setMoviename(rs.getString(2));
		m.setTickets(rs.getInt(3));
		m.setPrice(rs.getInt(4));
		m.setDate1(rs.getString(5));
		m.setShowtime(rs.getString(6));
	movie.add(m);
	}
	}catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return movie;
	}



	
	public String update(int movieid,String moviename,int tickets,int price,String date,String showtime,int seats) {



	String msg="";



	try {
	Connection con = DBUtility.getConnection();
	System.out.println("updatemethod");
	PreparedStatement ps = con.prepareStatement("update movie set moviename=?,tickets=?,price=?,date=?,showtime=?,seats=? where movieid=? ");



	ps.setString(1,moviename);
	ps.setInt(2, tickets);
	ps.setInt(3, price);
	ps.setString(4,date);
	ps.setString(5,showtime);
	ps.setInt(6, seats);
	ps.setInt(7, movieid);
	int i =ps.executeUpdate();


	if(i!=0)
	{
	msg="records updated sucesfully";
	}
	else {
		msg="records not updated";
	}

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return msg;
	}



	public String delete(int movieid) {
	String msg="";
	try
	{
	Connection con = DBUtility.getConnection();
	PreparedStatement ps = con.prepareStatement("delete from movie where movieid=?");
	ps.setInt(1,movieid);
	int i =ps.executeUpdate();


	if(i!=0)
	{
	msg="records deleted sucessfully";
	}
	else
	{
	msg="records not deleted";
	}



	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return msg;
	}



	}


