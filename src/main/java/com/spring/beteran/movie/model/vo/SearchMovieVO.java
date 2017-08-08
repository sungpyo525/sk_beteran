package com.spring.beteran.movie.model.vo;

public class SearchMovieVO {
	private String movieName, directorName, movieGenre;
	private String openStartDate, openEndDate;
	
	public SearchMovieVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchMovieVO(String movieName, String directorName, String movieGenre, String openStartDate,
			String openEndDate) {
		super();
		this.movieName = movieName;
		this.directorName = directorName;
		this.movieGenre = movieGenre;
		this.openStartDate = openStartDate;
		this.openEndDate = openEndDate;
	}



	public String getOpenEndDate() {
		return openEndDate;
	}

	public void setOpenEndDt(String openEndDt) {
		this.openEndDate = openEndDt;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getOpenStartDate() {
		return openStartDate;
	}

	public void setOpenStartDate(String openStartDate) {
		this.openStartDate = openStartDate;
	} 
	
	
}
