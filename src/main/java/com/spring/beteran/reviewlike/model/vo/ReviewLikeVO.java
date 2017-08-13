package com.spring.beteran.reviewlike.model.vo;

public class ReviewLikeVO {
	private String userid;
	private int rvid;
	private int countlike;
	public ReviewLikeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewLikeVO(String userid, int rvid, int countlike) {
		super();
		this.userid = userid;
		this.rvid = rvid;
		this.countlike = countlike;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getRvid() {
		return rvid;
	}
	public void setRvid(int rvid) {
		this.rvid = rvid;
	}
	public int getCountlike() {
		return countlike;
	}
	public void setCountlike(int countlike) {
		this.countlike = countlike;
	}
	
	

}
