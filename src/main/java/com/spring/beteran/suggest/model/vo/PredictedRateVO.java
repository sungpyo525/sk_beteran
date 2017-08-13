package com.spring.beteran.suggest.model.vo;

public class PredictedRateVO {
	private int movieid;
	private double rate;
	private String moviename;
	public PredictedRateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PredictedRateVO(int movieid, double rate) {
		super();
		this.movieid = movieid;
		this.rate = rate;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	
}
