package com.spring.beteran;

import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.beteran.user.model.vo.UserVO;
import com.spring.beteran.user.service.UserService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping(value = "/main.bt", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Ctrl Home");
		System.out.println("Ctrl Test list");
		ArrayList<UserVO> list = service.list();
		model.addAttribute("lists",list);
		return "home" ;
	}
	
}
