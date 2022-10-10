package com.ojas.model;

public class BookList {

	private Movie movie;
	private int amount;
	public BookList ()
	{
		
	}
	public BookList(Movie movie, int amount) {
		super();
		this.movie = movie;
		this.amount = amount;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
