package com.ojas.model;
import java.sql.Time;
import java.util.*;

public class Movie {
    private int movieid;
	private String moviename;
	private String date1;
	private String showtime;
	private int price;
	private int seatnum;
	private int numoftickets;
	private int tickets;
	public Movie()
	{
	
	}
		
	public Movie(int movieid, String moviename, String date1, String showtime, int price,int seatnum,int numoftickets,int tickets) {
		super();
		this.movieid = movieid;
		this.moviename = moviename;
		this.date1 = date1;
		this.showtime = showtime;
		this.price = price;
		this.seatnum= seatnum;
		this.numoftickets=numoftickets;
		this.tickets=tickets;

	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSeatnum() {
		return seatnum;
	}

	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}

	public int getNumoftickets() {
		return numoftickets;
	}

	public void setNumoftickets(int numoftickets) {
		this.numoftickets = numoftickets;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", moviename=" + moviename + ", date=" + date1 + ", showtime=" + showtime
				+ ", price=" + price + ", seatnum=" + seatnum + ", numoftickets=" + numoftickets + ", tickets="
				+ tickets + "]";
	}

	
		
	}

		
	
	
	
