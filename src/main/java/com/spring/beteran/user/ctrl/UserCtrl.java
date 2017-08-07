package com.spring.beteran.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.user.model.vo.UserVO;
import com.spring.beteran.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCtrl {
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("/login.bt")
	public String login(UserVO user, HttpSession session) {
		System.out.println("Ctrl BTR Login");
		UserVO result = service.login(user);
		session.setAttribute("loginUser", result);
		return "redirect:/main.bt";
	}
	
	@RequestMapping("/logout.bt")
	public String logout (HttpSession session) {
		System.out.println("Ctrl logout");
		session.invalidate();
		return "redirect:/main.bt";
	}
	
	@RequestMapping("/loginPost.bt")
	public String form() {
		System.out.println("Ctrl LoginForm");
		return "/user/login";
	}
}
