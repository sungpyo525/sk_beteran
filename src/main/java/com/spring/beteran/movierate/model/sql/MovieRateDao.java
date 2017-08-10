package com.spring.beteran.movierate.model.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.movierate.model.vo.MovieRateVO;

@Repository("movieRateDao")
public class MovieRateDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public int rateRegisterRow(MovieRateVO movie) {
		System.out.println("Dao rateRegisterRow");
		System.out.println(movie.getMovieid());
		System.out.println(movie.getMovierate());
		System.out.println(movie.getUserid());
		return session.insert("com.spring.beteran.movierate.movierate", movie);
	}

}
