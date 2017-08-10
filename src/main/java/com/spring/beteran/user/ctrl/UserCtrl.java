package com.spring.beteran.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.user.model.vo.UserVO;
import com.spring.beteran.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCtrl {
	@Resource(name="userService")
	private UserService service;
	
	// Interceptor 적용함.
	@RequestMapping("/login.bt")
	public void login(UserVO user, Model model) {
		System.out.println("Ctrl BTR Login");
		UserVO result = service.login(user);
		model.addAttribute("loginUser", result);
		//return "redirect:/main.bt";
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
	
	@RequestMapping("/registerForm.bt")
	public String registerForm() {
		System.out.println("Go to Form");
		return "/user/registerForm";
	}
	
	@RequestMapping("/register.bt")
	public String register(UserVO user) {
		System.out.println("Ctrl User Register");
		int result= service.register(user);
		return "redirect:/main.bt";
	}
	
	@RequestMapping("/userInfo.bt")
	public String userInfo(UserVO user, Model model){
		System.out.println("Ctrl userInfo");
		UserVO result = service.userInfo(user);
		model.addAttribute("loginUser", result);
		System.out.println("result "+ result.getBirth());
		return "/user/userInfo";
	}
	
	@RequestMapping("/userInfoModify.bt")
	public String userInfoModify(UserVO user){
		System.out.println("Ctrl User Info Modify");
		int result = service.userInfoModify(user);
		return "redirect:/user/userInfo.bt?userid="+user.getUserid();
	}
	
	@RequestMapping("/deleteUser.bt")
	public String deleteUser(UserVO user, Model model) {
		System.out.println("Ctrl Delete User");
		System.out.println("id : "+user.getUserid());
		int result = service.deleteUser(user);
		return "redirect:/user/logout.bt";
	}
}
