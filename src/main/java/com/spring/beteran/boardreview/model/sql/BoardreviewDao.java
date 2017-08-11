package com.spring.beteran.boardreview.model.sql;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.boardreview.model.vo.BoardreviewVO;
import com.spring.beteran.boardreview.util.vo.BoardreviewSearchVO;

@Repository("boardDao")
public class BoardreviewDao {

	@Resource(name = "sqlSession")
	private SqlSession session;

	public ArrayList<BoardreviewVO> listRow() {
		System.out.println("Dao listRow");
		return (ArrayList) session.selectList("com.spring.beteran.board.list");

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
}