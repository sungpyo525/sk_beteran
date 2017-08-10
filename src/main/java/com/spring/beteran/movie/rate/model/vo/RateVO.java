package com.spring.beteran.movie.rate.model.vo;

public class RateVO {
	private String movieid, userid; 
	private double movierate;
	
	public RateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RateVO(String movieid, String userid, double movierate) {
		super();
		this.movieid = movieid;
		this.userid = userid;
		this.movierate = movierate;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
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
