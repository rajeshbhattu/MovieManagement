package com.ojas.mms.dao;
import com.ojas.model.Movie;
import java.util.List;
public interface AdminDao {
	public String addMovie(int movieid,String moviename,int tickets,int price,String date,String showtime,int seats);
	public Movie viewMovie(int movieid);
	public List<Movie> viewAllMovie();
	public String update(int movieid,String moviename,String date,String showtime,int price,int seatnum);



	public String delete(int movieid);



	}


