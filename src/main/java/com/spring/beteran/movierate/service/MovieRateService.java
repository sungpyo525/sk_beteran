package com.spring.beteran.movierate.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movie.rate.model.vo.RateVO;
import com.spring.beteran.movierate.model.sql.MovieRateDao;
import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.user.model.vo.UserVO;

@Service("movieRateService")
public class MovieRateService {
	
	@Resource(name="movieRateDao")
	private MovieRateDao dao;
	
	public ArrayList<MovieVO> list(){
		System.out.println("Service movie list");
		return dao.movielistRow();
	}
	
	public ArrayList<MovieRateVO> listRate(UserVO user){
		System.out.println("Service Movierate list");
		return dao.movielistRateRow(user);
	}

	public int rateRegister(MovieRateVO movie) {
		System.out.println("Service rateRegister");
		return dao.rateRegisterRow(movie);
	}
	
	public int deleteRate(MovieRateVO rate) {
		System.out.println("Service rateDelete");
		return dao.deleteRateRow(rate);
	}

	public int getUpdate(MovieRateVO movie) {
		System.out.println("Service rateUpdate");
		return dao.updateRateRow(movie);
	}

	public int checkRate(MovieRateVO rate) {
		System.out.println("Service checkRate");
		return dao.checkRate(rate);
	}


}
