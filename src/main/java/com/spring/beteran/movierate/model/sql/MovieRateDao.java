package com.spring.beteran.movierate.model.sql;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movie.rate.model.vo.RateVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.user.model.vo.UserVO;

@Repository("movieRateDao")
public class MovieRateDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public ArrayList<MovieVO> movielistRow(){
		System.out.println("Dao movielistRow");
		return (ArrayList)session.selectList("com.spring.beteran.movie.movie");
	}
	
	public ArrayList<MovieRateVO> movielistRateRow(UserVO user){
		System.out.println("Dao movielistRateRow");
		return (ArrayList)session.selectList("com.spring.beteran.movie.movieRate", user);
	}
	
	public int rateRegisterRow(MovieRateVO movie) {
		System.out.println("Dao rateRegisterRow");
		System.out.println(movie.getMovieid());
		System.out.println(movie.getMovierate());
		System.out.println(movie.getUserid());
		return session.insert("com.spring.beteran.movierate.movierate", movie);
	}
	
	public int deleteRateRow(MovieRateVO rate) {
		System.out.println("Dao rateDeleteRow");
		return session.delete("com.spring.beteran.movie.deleteRate", rate);
	}
	
	public int updateRateRow(MovieRateVO movie) {
		System.out.println("Dao updateRateRow");
		System.out.println(movie.getMovieid());
		System.out.println(movie.getUserid());
		return session.update("com.spring.beteran.movierate.updateRate", movie);
	}

	public int checkRate(MovieRateVO rate) {
		System.out.println("Dao checkRate");
		return session.selectOne("com.spring.beteran.movierate.checkRate", rate);
	}

}
