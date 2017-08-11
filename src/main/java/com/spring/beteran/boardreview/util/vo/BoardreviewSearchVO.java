package com.spring.beteran.boardreview.util.vo;

public class BoardreviewSearchVO {

	private String searchType, searchKeyword;

	public BoardreviewSearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardreviewSearchVO(String searchType, String searchKeyword) {
		super();
		this.searchType = searchType;
		this.searchKeyword = searchKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}