package com.ojas.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
//import java.sql.Time;
import java.util.*;

import com.ojas.mms.db.DBUtility;
import com.ojas.model.BookList;
import com.ojas.model.Movie;

public class CustomerDaoImpl implements CustomerDao {
	

	public Movie viewMovie(String movieName) {
		Movie m=new Movie();
	
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from movie where movieName=?");
			ps.setString(1,movieName);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
			m.setMoviename(rs.getString(1));
			m.setDate1(rs.getString(2));
			m .setShowtime(rs.getString(3));
			m.setPrice(rs.getInt(4));
			m.setSeatnum(rs.getInt(5));

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return m;
}
	public List<Movie> viewAll() {
	
List<Movie> ml=new ArrayList<Movie>();
Movie m=new Movie();
try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Movie ");
			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				m.setMovieid(rs.getInt(1));
			m.setMoviename(rs.getString(2));
			m.setSeatnum(rs.getInt(3));
			m.setPrice(rs.getInt(4));
			ml.add(m);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return ml;
}
		
		
	
public String bookTickets(int bid,int movieid,String moviename,String date,String  showtime,int seatnum,int numoftickets)
{
	
	String msg = "";
	int price=500;
	List<Movie> ml=new ArrayList<Movie>();
	Movie m=new Movie();
	try {
		Connection con = DBUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO booklist(bid,movieid,moviename,date,showtime,numoftickets,seatnum) VALUES(?,?,?,?,?,?,?)");
		ps.setInt(1, bid);
		ps.setInt(2,movieid);
		ps.setString(3,moviename);
		ps.setString(4,  date);
	ps.setString(5, showtime);
	ps.setInt(6,seatnum);
	//ps.setInt(5,price);
	ps.setInt(7,numoftickets);
	int amount1 =price* numoftickets;
	
	//con.prepareStatement("INSERT INTO booklist(amount)  values(?) where bid=?");
//	ps.setInt(8,amount1);
		int n = ps.executeUpdate();
		
		if(n!=0) {
			msg = "Successfully tickets booked......";
			
			
		
			}
			
		else {
			msg = "failed to book tickets .Please try again...";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return msg;
}
public String cancelTickets(int movieid)
{
	String msg="";
try 
{
Connection con = DBUtility.getConnection();
	PreparedStatement ps = con.prepareStatement("delete  from booklist where movieid=?");
	ps.setInt(1,movieid);

	int i	=ps.executeUpdate();

	
if(i!=0)
{
msg="records deleted sucessfully";
}

} catch (SQLException e) {
e.printStackTrace();
} 
return msg;
}

/*public List<Movie> bookList(int bid)
{
	List<Movie> ml=new ArrayList<Movie>();

	Movie m=new Movie();
	try {
	Connection con = DBUtility.getConnection();
	PreparedStatement ps = con.prepareStatement("select * from booklist where bid=?");
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			m.setMovieId(rs.getInt(1));
		m.setMoviename(rs.getString(2));
		m.setSeatnum(rs.getInt(3));
		m.setPrice(rs.getInt(4));
		int amount=rs.getInt(5);
		ml.add(amount);
		ml.add(m);
		
		}
		

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return ml;
}*/
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




