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
	
}
