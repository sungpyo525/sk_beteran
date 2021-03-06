package com.spring.beteran.movie.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.movie.model.sql.MovieDao;
import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;

@Service("movieService")
public class MovieService {
	
	@Resource(name="movieDao")
	private MovieDao dao;
	
	public ArrayList<MovieVO> list(){
		System.out.println("Service movie list");
		return dao.movielistRow();
	}
	
	public ArrayList<MovieRateVO> listRate(){
		System.out.println("Service Movierate list");
		return dao.movielistRateRow();
	}

	public MovieVO selectRow(MovieVO movie) {
		System.out.println("movieService : selectRow");
		return dao.selectRow(movie);
	}

	public int insert(MovieVO movie) {
		System.out.println("movieService : insert");
		return dao.insert(movie);
	}

	public int getMovieId(MovieVO movie) {
		System.out.println("movieService : getMovieId");
		return dao.getMovieId(movie);
	}

	public String getMovieName(MovieVO movie) {
		System.out.println("movieService : getMovieName");
		return dao.getMovieName(movie);
	}
}
