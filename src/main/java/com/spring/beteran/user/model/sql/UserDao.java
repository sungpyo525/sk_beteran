package com.spring.beteran.user.model.sql;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.beteran.user.model.vo.UserVO;

@Repository("userDao")
public class UserDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;

	public ArrayList<UserVO> listRow() {
		System.out.println("User - Dao - listRow");
		
		return (ArrayList)session.selectList("com.spring.beteran.user.list");
	}

	public UserVO loginRow(UserVO user) {
		System.out.println("Dao BTR loginRow");
		return session.selectOne("com.spring.beteran.user.login", user);
	}

	public int registerUser(UserVO user) {
		System.out.println("Dao BTR Register user");
		return session.insert("com.spring.beteran.user.register", user);
	}

}
