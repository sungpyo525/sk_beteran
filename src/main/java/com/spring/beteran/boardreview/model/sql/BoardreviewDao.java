package com.spring.beteran.boardreview.model.sql;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.boardreview.model.vo.BoardreviewVO;
import com.spring.beteran.boardreview.util.vo.BoardreviewSearchVO;
import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.reviewlike.model.vo.ReviewLikeVO;
import com.spring.beteran.user.model.vo.UserVO;

import kr.or.kobis.kobisopenapi.consumer.soap.movie.Movie;

@Repository("boardDao")
public class BoardreviewDao {

	@Resource(name = "sqlSession")
	private SqlSession session;

	public ArrayList<BoardreviewVO> listRow(UserVO user) {
		System.out.println("Dao listRow");
		return (ArrayList) session.selectList("com.spring.beteran.board.listWithMovieName",user);

	}

	public ArrayList<BoardreviewVO> searchRow(BoardreviewSearchVO search) {
		System.out.println("Dao searchRow");
		return (ArrayList) session.selectList("com.spring.beteran.board.search", search);

	}

	

	public int registerRow(BoardreviewVO board) {
		System.out.println("Dao registerRow");

		return session.insert("com.spring.beteran.board.register", board);
		// 마이바티스와 연동 //식별자 id
	}

	public int modifyRow(BoardreviewVO board) {
		System.out.println("Dao modifyRow");

		return session.update("com.spring.beteran.board.modify", board);
		// 마이바티스와 연동

	}
	// 식별자 id

	public BoardreviewVO modifyFormRow(BoardreviewVO board) {
		System.out.println("Dao modifyFormRow");

		return session.selectOne("com.spring.beteran.board.modifyForm", board);

	}

	public int deleteRow(BoardreviewVO board) {
		System.out.println("Dao deleteRow");
		return session.delete("com.spring.beteran.board.delete", board);
	}

	public int insertLikeRow(ReviewLikeVO like) {
		System.out.println("Dao insertLikeRow");
		return session.insert("com.spring.beteran.board.insertLike", like);
	}

	public ReviewLikeVO selectCountLikeRow(ReviewLikeVO like) {
		System.out.println("Dao selectCountLikeRow");
		return session.selectOne("com.spring.beteran.board.selectCountLike", like);
	}

	public ReviewLikeVO showLikeBtnRow(ReviewLikeVO like) {
		System.out.println("Dao showLikeBtnRow");
		return session.selectOne("com.spring.beteran.board.showLikeBtn", like);
	}

	public int deleteLikeRow(ReviewLikeVO like) {
		System.out.println("Dao deleteLikeRow");
		return session.delete("com.spring.beteran.board.deleteLike", like);
	}

	public MovieVO findMovieIdRow(MovieVO movie) {
		System.out.println("Dao findMovieIdRow");
		return session.selectOne("com.spring.beteran.board.findMovieId",movie);
	}

	public ArrayList<BoardreviewVO> goReviewRow(BoardreviewVO review) {
		System.out.println("Dao goReviewRow");
		return (ArrayList)session.selectList("com.spring.beteran.board.goReview", review);
	}
}