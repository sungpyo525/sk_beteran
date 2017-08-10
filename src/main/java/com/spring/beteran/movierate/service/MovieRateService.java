package com.spring.beteran.movierate.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.movierate.model.sql.MovieRateDao;
import com.spring.beteran.movierate.model.vo.MovieRateVO;

@Service("movieRateService")
public class MovieRateService {
	
	@Resource(name="movieRateDao")
	private MovieRateDao dao;

	public int rateRegister(MovieRateVO movie) {
		System.out.println("Service rateRegister");
		return dao.rateRegisterRow(movie);
	}

	


}
