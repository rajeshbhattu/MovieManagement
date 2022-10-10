package com.ojas.mms.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.ojas.model.Movie;

public interface CustomerDao {
	public Movie viewMovie(String movieName);
public List<Movie> viewAll();
	public String bookTickets(int bid ,int movieId,String movieName,String date,String showtime,int seatnum ,int numoftickets);
	public String cancelTickets(int movieId);
	//public List<Movie> bookList(int bid);
	
	}
