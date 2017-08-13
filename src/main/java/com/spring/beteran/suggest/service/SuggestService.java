package com.spring.beteran.suggest.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.suggest.model.sql.SuggestDao;

@Service("suggestService")
public class SuggestService {
	
	@Resource(name="suggestDao")
	private SuggestDao dao;

	public ArrayList<MovieRateVO> rateList() {
		System.out.println("Service rateList");
		return dao.rateListRow();
	}


	
}
