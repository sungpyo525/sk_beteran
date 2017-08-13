package com.spring.beteran.user.model.vo;

public class SimUserVO {
	private String userid;
	private double similarity;
	public SimUserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SimUserVO(String userid, double similarity) {
		super();
		this.userid = userid;
		this.similarity = similarity;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public double getSimilarity() {
		return similarity;
	}
	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}
	
	
}
