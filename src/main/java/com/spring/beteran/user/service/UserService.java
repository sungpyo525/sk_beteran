package com.spring.beteran.user.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.beteran.user.model.sql.UserDao;
import com.spring.beteran.user.model.vo.UserVO;

@Service("userService")
public class UserService {

	@Resource(name="userDao")
	private UserDao dao;
	
	public ArrayList<UserVO> list() {
		System.out.println("User - Service - list");
		return dao.listRow();
	}

	public UserVO login(UserVO user) {
		System.out.println("Service BTR login");
		return dao.loginRow(user);
	}

	public int register(UserVO user) {
		System.out.println("Service User Register");
		return dao.registerUser(user);
	}

	public UserVO userInfo(UserVO user) {
		System.out.println("Service UserInfo about : " +user.getUserid());
		return dao.userInfoRow(user);
	}

	public int userInfoModify(UserVO user) {
		System.out.println("Service userInfoModify");
		return dao.userInfoModifyRow(user);
	}

	public int deleteUser(UserVO user) {
		System.out.println("Service deleteUser");
		return dao.deleteUserRow(user);
	}

	public UserVO userIdCheck(UserVO user) {
		System.out.println("Service userIdCheck");
		return dao.userIdCheckRow(user);
	}
	
}
