package com.spring.beteran.movierate.model.vo;

public class MovieRateVO {
	
	private int movieid;
	private String userid;
	private double movierate;
	public MovieRateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieRateVO(int movieid, String userid, double movierate) {
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
