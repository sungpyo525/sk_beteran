package com.spring.beteran.boardreview.model.vo;

public class BoardreviewVO {

	private int rvid,movieid;
	private String rvtitle, rvcontent, userid, rvregdate, moviename, moviedate;
	public BoardreviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMoviedate() {
		return moviedate;
	}


	public void setMoviedate(String moviedate) {
		this.moviedate = moviedate;
	}


	public BoardreviewVO(int rvid, int movieid, String rvtitle, String rvcontent, String userid, String rvregdate,
			String moviename, String moviedate) {
		super();
		this.rvid = rvid;
		this.movieid = movieid;
		this.rvtitle = rvtitle;
		this.rvcontent = rvcontent;
		this.userid = userid;
		this.rvregdate = rvregdate;
		this.moviename = moviename;
		this.moviedate = moviedate;
	}


	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public int getRvid() {
		return rvid;
	}
	public void setRvid(int rvid) {
		this.rvid = rvid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
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
	
	
	
	
}