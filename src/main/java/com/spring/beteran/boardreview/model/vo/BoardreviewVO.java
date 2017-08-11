package com.spring.beteran.boardreview.model.vo;

public class BoardreviewVO {

	private int rvid;
	private String rvtitle, rvcontent, userid, rvregdate, movieid;
	public BoardreviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardreviewVO(int rvid, String rvtitle, String rvcontent, String userid, String rvregdate, String movieid) {
		super();
		this.rvid = rvid;
		this.rvtitle = rvtitle;
		this.rvcontent = rvcontent;
		this.userid = userid;
		this.rvregdate = rvregdate;
		this.movieid = movieid;
	}
	public int getRvid() {
		return rvid;
	}
	public void setRvid(int rvid) {
		this.rvid = rvid;
	}
	public String getRvtitle() {
		return rvtitle;
	}
	public void setRvtitle(String rvtitle) {
		this.rvtitle = rvtitle;
	}
	public String getRvcontent() {
		return rvcontent;
	}
	public void setRvcontent(String rvcontent) {
		this.rvcontent = rvcontent;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRvregdate() {
		return rvregdate;
	}
	public void setRvregdate(String rvregdate) {
		this.rvregdate = rvregdate;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	
	
}