package com.spring.beteran.boardreview.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.boardreview.model.sql.BoardreviewDao;
import com.spring.beteran.boardreview.model.vo.BoardreviewVO;
import com.spring.beteran.boardreview.util.vo.BoardreviewSearchVO;

@Service("boardService")
public class BoardreviewService {

	@Resource(name = "boardDao")
	private BoardreviewDao dao;

	public ArrayList<BoardreviewVO> list() {

		System.out.println("Service list");
		return dao.listRow();
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

}
