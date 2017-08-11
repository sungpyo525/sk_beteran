package com.spring.beteran.movie.rate.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movie.rate.model.vo.RateVO;
import com.spring.beteran.movie.service.MovieService;
import com.spring.beteran.user.model.vo.UserVO;

@Controller
@RequestMapping("/rate")
public class RateCtrl {
	
	@Resource(name="movieService")
	private MovieService service;
	
	@RequestMapping("/rateInsert.bt")
	public String rate(RateVO rate, UserVO user, MovieVO movie) {
		
		System.out.println("얍얍 여기는 RateCtrl의 rate메서드");
		System.out.println("들어온 유저 아이디는 : "+user.getUserid());
		
		rate.setUserid(user.getUserid());
		
		System.out.println("평점은 : " +rate.getMovierate());
		System.out.println("MovieVO에 걸려서 들어온 값들 : "+movie.getMoviename() +"///"+movie.getMoviedirector()+"///"+movie.getMoviedate() );
		
		//1.유저의 평점을 입력하기 이전에 movie 테이블에 해당 영화정보가 저장이 되어있는지 확인
		//1-1 안되어있다면 해당 영화정보를 영화 테이블에 저장먼저
		
		//check movie table
		MovieVO checkMovie = service.selectRow(movie);
		System.out.println("영화테이블에 데이터가 있나요?? 영화 이름?"+checkMovie.getMoviename());
		if(checkMovie.getMoviename() == "NoMovie") {
			int ch = service.insert(movie);
			System.out.println("insert 결과 : "+ ch);
		}
		return "home";
	}
}
