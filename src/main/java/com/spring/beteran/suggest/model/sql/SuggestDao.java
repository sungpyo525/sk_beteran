package com.spring.beteran.suggest.model.sql;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;

@Repository("suggestDao")
public class SuggestDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	


	public ArrayList<MovieRateVO> rateListRow() {
		System.out.println("Dao rateList");
		return (ArrayList)session.selectList("com.spring.beteran.suggest.rateList");
	}
	
}
