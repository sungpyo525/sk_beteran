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

	public MovieVO selectRow(MovieVO movie) {
		System.out.println("movieDao : selectRow 영화 하나 불러옵니다.");
		MovieVO result = session.selectOne("com.spring.beteran.movie.selectRow", movie);
		if(result == null) {
			System.out.println("	테이블에 데이터 없어 from DAO");
			MovieVO no = new MovieVO();
			no.setMoviename("NoMovie");
			return no;
		}else {
			System.out.println("	테이블에 검색된 데이터 보낸다.from DAO");
			return result;
		}
	}

	public int insert(MovieVO movie) {
		System.out.println("movieDao : insert / table에 영화 데이터 입력합니다.");
		System.out.println("넣을 영화 데이터 : "+ movie.getMoviename() +" / "+ movie.getMoviedate() +" / "+ movie.getMoviedirector());
		int result = session.insert("com.spring.beteran.movie.insert", movie);
		
		return result;
	}

	public int getMovieId(MovieVO movie) {
		System.out.println("movieDao : getMovieId : "+ movie.getMoviename());
		return session.selectOne("com.spring.beteran.movie.getId", movie);
	}
}
