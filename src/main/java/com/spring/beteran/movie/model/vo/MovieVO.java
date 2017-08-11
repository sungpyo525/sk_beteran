package com.spring.beteran.movie.model.vo;

public class MovieVO {
	private int	movieid;
	private String	moviename, moviedirector, moviedate, movienation, moviesummary;
	
	public MovieVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieVO(int movieid, String moviename, String moviedirector, String moviedate, String movienation,
			String moviesummary) {
		super();
		this.movieid = movieid;
		this.moviename = moviename;
		this.moviedirector = moviedirector;
		this.moviedate = moviedate;
		this.movienation = movienation;
		this.moviesummary = moviesummary;
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
	public String getMoviedirector() {
		return moviedirector;
	}
	public void setMoviedirector(String moviedirector) {
		this.moviedirector = moviedirector;
	}
	public String getMoviedate() {
		return moviedate;
	}
	public void setMoviedate(String moviedate) {
		this.moviedate = moviedate;
	}
	public String getMovienation() {
		return movienation;
	}
	public void setMovienation(String movienation) {
		this.movienation = movienation;
	}
	public String getMoviesummary() {
		return moviesummary;
	}
	public void setMoviesummary(String moviesummary) {
		this.moviesummary = moviesummary;
	}
	
	
}
