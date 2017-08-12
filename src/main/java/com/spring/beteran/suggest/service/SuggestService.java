package com.spring.beteran.suggest.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;

@Service("suggestService")
public class SuggestService {
	@Resource(name="suggestDao")
	private SuggestDao dao;
	public ArrayList<MovieVO> movieIdList() {
		System.out.println("Service movieIdList");
		return dao.movieIdListRow();
	}

	public ArrayList<MovieRateVO> rateListByMovie() {
		System.out.println("Service rateListByMovie");
		return dao.rateListByMovieRow();
	}


	
}
