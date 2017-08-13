package com.spring.beteran.movie.rate.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movie.service.MovieService;
import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.movierate.service.MovieRateService;
import com.spring.beteran.user.model.vo.UserVO;

@Controller
@RequestMapping("/rate")
public class RateCtrl {
	
	@Resource(name="movieService")
	private MovieService service;
	
	@Resource(name="movieRateService")
	private MovieRateService movieRateService;
	
	@RequestMapping("/rateInsert.bt")
	public String rate(MovieRateVO rate, UserVO user, MovieVO movie) {
		
		System.out.println("얍얍 여기는 RateCtrl의 rate메서드");
		System.out.println("들어온 유저 아이디는 : "+user.getUserid());
		
		rate.setUserid(user.getUserid());
		
		System.out.println("평점은 : " +rate.getMovierate());
		System.out.println("MovieVO에 걸려서 들어온 값들 : "+movie.getMoviename() +"///"+movie.getMoviedirector()+"///"+movie.getMoviedate() );
		
		//1.유저의 평점을 입력하기 이전에 movie 테이블에 해당 영화정보가 저장이 되어있는지 확인
		//1-1 안되어있다면 해당 영화정보를 영화 테이블에 저장먼저
		
		//check movie table : 해당 영화정보가 없으면 insert해준다
		MovieVO checkMovie = service.selectRow(movie);
		System.out.println("영화테이블에 데이터가 있나요?? 영화 이름?"+checkMovie.getMoviename());
		if(checkMovie.getMoviename() == "NoMovie") {
			int ch = service.insert(movie);
			System.out.println("insert 결과 : "+ ch);
		}
		
		//영화이름과 년도로 movieid 얻기
		int getId = service.getMovieId(movie);
		rate.setMovieid(getId);
		
		//check rate table : 이미 해당 영화의 평점 입력했는지 체크. -> 했으면 update, 안했으면 insert
		System.out.println("입력할 rateVO의 값 : "+rate.getMovieid()+" / "+rate.getUserid() + " / " + rate.getMovierate());
		int checkRate = movieRateService.checkRate(rate);
		if(checkRate == 0) {//select count(*) from movierate where movieid and userid 를 사용 이미 입력했다면 1, 안했다면 0이 나온다.
			//0이 나왔으므로 그냥 insert한다.
			int insertResult = movieRateService.rateRegister(rate);
			if(insertResult == 1) {
				System.out.println("입력 성공");
			}
		}else {
			//1이 나왔으므로 update한다.
			int updateResult = movieRateService.getUpdate(rate);
			if(updateResult == 1) {
				System.out.println("업데이트 성공");
			}
		}
		
		return "redirect:/main.bt";
	}
}
