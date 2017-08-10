package com.spring.beteran.movierate.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.movierate.service.MovieRateService;
import com.spring.beteran.user.model.vo.UserVO;

@Controller
@RequestMapping("/movieRate")
public class MovieRateCtrl {
	
	@Resource(name="movieRateService")
	private MovieRateService service;
	
	
	@RequestMapping("/rateRegister.bt")
	public String rateRegister(MovieRateVO movie, UserVO user) {
		System.out.println("Ctrl rateRegister");
		
		movie.setUserid(user.getUserid());
		movie.getMovieid();
		
		int flag = service.rateRegister(movie);
		
		return "redirect:/movie/movieRate.bt";
	}

}
