package com.spring.beteran.movie.rate.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.movie.rate.model.vo.RateVO;
import com.spring.beteran.user.model.vo.UserVO;

@Controller
@RequestMapping("/rate")
public class RateCtrl {
	
	@RequestMapping("/rateInsert.bt")
	public String rate(RateVO rate, UserVO user) {
		
		System.out.println("얍얍 여기는 RateCtrl의 rate메서드");
		System.out.println("들어온 유저 아이디는 : "+user.getUserid());
		System.out.println("평가할 영화 아이디는 : "+rate.getMovieid());
		
		rate.setUserid(user.getUserid());
		
		System.out.println(rate.getMovierate());
		return "home";
	}
}
