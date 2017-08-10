package com.spring.beteran.movie.model.sql;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;

@Repository("movieDao")
public class MovieDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public ArrayList<MovieVO> movielistRow(){
		System.out.println("Dao movielistRow");
		return (ArrayList)session.selectList("com.spring.beteran.movie.movie");
	}
	
	public ArrayList<MovieRateVO> movielistRateRow(){
		System.out.println("Dao movielistRateRow");
		return (ArrayList)session.selectList("com.spring.beteran.movie.movieRate");
	}

}
