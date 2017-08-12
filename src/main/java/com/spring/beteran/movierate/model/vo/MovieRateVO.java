package com.spring.beteran.movierate.model.vo;

public class MovieRateVO {
	
	private int movieid;
	private String userid;
	private double movierate;
	private String moviename; //존나 신기
	public MovieRateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieRateVO(int movieid, String userid, double movierate, String moviename) {
		super();
		this.movieid = movieid;
		this.userid = userid;
		this.movierate = movierate;
		this.moviename = moviename;
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
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	
}