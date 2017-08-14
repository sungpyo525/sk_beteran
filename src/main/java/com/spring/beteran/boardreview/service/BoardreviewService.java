package com.spring.beteran.boardreview.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.boardreview.model.sql.BoardreviewDao;
import com.spring.beteran.boardreview.model.vo.BoardreviewVO;
import com.spring.beteran.boardreview.util.vo.BoardreviewSearchVO;
import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.reviewlike.model.vo.ReviewLikeVO;
import com.spring.beteran.user.model.vo.UserVO;

@Service("boardService")
public class BoardreviewService {

	@Resource(name = "boardDao")
	private BoardreviewDao dao;

	public ArrayList<BoardreviewVO> list(UserVO user) {

		System.out.println("Service list");
		return dao.listRow(user);
	}

	public ArrayList<BoardreviewVO> search(BoardreviewSearchVO search) {

		System.out.println("Service search");
		return dao.searchRow(search);
	}

	

	public int register(BoardreviewVO board) {

		System.out.println("Service register");
		return dao.registerRow(board);
	}

	public int modify(BoardreviewVO board) {

		System.out.println("Service modify");
		return dao.modifyRow(board);
	}

	public BoardreviewVO modifyForm(BoardreviewVO board) {

		System.out.println("Service modifyForm");
		return dao.modifyFormRow(board);
	}

	public int delete(BoardreviewVO board) {
		System.out.println("Service delete");
		return dao.deleteRow(board);
	}

	public int insertLike(ReviewLikeVO like) {
		System.out.println("Service insertLike");
		return dao.insertLikeRow(like);
	}

	public ReviewLikeVO selectCountLike(ReviewLikeVO like) {
		System.out.println("Service selectCountLike");
		return dao.selectCountLikeRow(like);
	}

	public ReviewLikeVO showLikeBtn(ReviewLikeVO like) {
		System.out.println("Service showLikeBtn");
		return dao.showLikeBtnRow(like);
	}

	public int deleteLike(ReviewLikeVO like) {
		System.out.println("Sevice deleteLike");
		return dao.deleteLikeRow(like);
	}

	public MovieVO findMovieId(MovieVO movie) {
		System.out.println("Service findMovieId");
		return dao.findMovieIdRow(movie);
	}

	public ArrayList<BoardreviewVO> goReview(BoardreviewVO review) {
		System.out.println("Service goReview");
		return dao.goReviewRow(review);
	}

}
