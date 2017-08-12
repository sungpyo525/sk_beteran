package com.spring.beteran.suggest.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;

@Repository
public class SuggestDao {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public ArrayList<MovieVO> movieIdListRow() {
		System.out.println("Dao movieIdListRow");
		return (ArrayList)session.selectList("com.spring.beteran.suggest.movieIdList");
	}

	public ArrayList<MovieRateVO> rateListByMovieRow() {
		System.out.println("Dao rateListByMovieRow");
		return (ArrayList)session.selectList("com.spring.beteran.suggest.rateListByMovieId");
	}
	
}
