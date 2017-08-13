package com.spring.beteran.movie.rate.model.vo;

public class RateVO {
	private int movieid;
	private String userid; 
	private double movierate;
	public RateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RateVO(int movieid, String userid, double movierate) {
		super();
		this.movieid = movieid;
		this.userid = userid;
		this.movierate = movierate;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public double getMovierate() {
		return movierate;
	}
	public void setMovierate(double movierate) {
		this.movierate = movierate;
	}
	
	
	
}
