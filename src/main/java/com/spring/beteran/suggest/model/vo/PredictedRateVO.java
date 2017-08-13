package com.spring.beteran.suggest.model.vo;

public class PredictedRateVO {
	private int movieid;
	private double rate;
	
	
	public PredictedRateVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public PredictedRateVO(int movieid, double rate) {
		super();
		this.movieid = movieid;
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
