package com.spring.beteran.movierate.ctrl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.movierate.service.MovieRateService;
import com.spring.beteran.user.model.vo.UserVO;

@Controller
@RequestMapping("/movieRate")
public class MovieRateCtrl {
	
	@Resource(name="movieRateService")
	private MovieRateService service;
	
	@RequestMapping("/movieRate.bt")
	public String list(UserVO user, Model model) {
		System.out.println("Ctrl Movielist");
		System.out.println("** : "+user.getUserid());
		ArrayList<MovieVO> list = service.list();
		ArrayList<MovieRateVO> listRate = service.listRate(user);
		model.addAttribute("movieRatelists", listRate);
		model.addAttribute("movielists", list); //서비스로직의 결과를 model객체에 담아 jsp에서 사용할 수있게
		return "movieRate/movielist";
	}
	
	@RequestMapping("/rateRegister.bt")
	public String rateRegister(MovieRateVO movie, UserVO user) {
		System.out.println("Ctrl rateRegister");
		
		movie.setUserid(user.getUserid());
		movie.getMovieid();
		
		//int flag = service.rateRegister(movie); //그냥 바로 insert하는것 대신에

		// check rate table : 이미 해당 영화의 평점 입력했는지 체크. -> 했으면 update, 안했으면 insert
		System.out.println(
				"입력할 rateVO의 값 : " + movie.getMovieid() + " / " + movie.getUserid() + " / " + movie.getMovierate());
		int checkRate = service.checkRate(movie);
		if (checkRate == 0) {// select count(*) from movierate where movieid and userid 를 사용 이미 입력했다면 1, 안했다면
								// 0이 나온다.
			// 0이 나왔으므로 그냥 insert한다.
			int insertResult = service.rateRegister(movie);
			if (insertResult == 1) {
				System.out.println("입력 성공");
			}
		} else {
			// 1이 나왔으므로 update한다.
			int updateResult = service.getUpdate(movie);
			if (updateResult == 1) {
				System.out.println("업데이트 성공");
			}
		}
		
		return "redirect:/movieRate/movieRate.bt?userid="+movie.getUserid();
	}
	
	@RequestMapping("/rateDelete.bt")
	public String deleteRate(MovieRateVO rate) {
		System.out.println("Ctrl deleteRate");
		System.out.println(rate.getUserid());
		System.out.println(rate.getMovieid());
		int result = service.deleteRate(rate);
		return "redirect:/movieRate/movieRate.bt?userid="+rate.getUserid();
	}

	
	@RequestMapping("/updateRate.bt")
	public String updateRate(MovieRateVO movie) {
		System.out.println("Ctrl updateRate");

		int result = service.getUpdate(movie);
		return "redirect:/movieRate/movieRate.bt?userid="+movie.getUserid();
	}

}
