package com.spring.beteran.suggest.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.suggest.service.SuggestService;

@Controller
@RequestMapping("/suggest")
public class SuggestCtrl {
	
	@Resource(name="suggestService")
	private SuggestService service;
	
	@RequestMapping("/suggestList.bt")
	public String suggestList() {
		System.out.println("Ctrl suggestList");
		
		// Outer Hash 선언
		HashMap<Integer, HashMap<String, Double>> outer=new HashMap<>();
		ArrayList<MovieRateVO> rateList = service.rateListByMovie();
		
		Iterator<MovieRateVO> ite = rateList.iterator();
		/*while(ite.hasNext()) {
		 * 여기 고쳐보기
			MovieRateVO rate = ite.next();
			HashMap<String, Double> inner = new HashMap<String, Double>();
			inner.put(rate.getUserid(), rate.getMovierate());
			if(outer.get(rate.getMovieid()) == null) {
				outer.put(rate.getMovieid(), inner);
			}else {
				HashMap<String, Double> inner2 = outer.get(rate.getMovieid());
				//inner2.put(rate.getUserid(),)
			}
			
			
		}*/
		
		// MOVIE 테이블, MOVIEID 목록 불러오기
		//ArrayList<MovieVO> movieIdList = service.movieIdList();
		
		//Iterator<MovieVO> ite = movieIdList.iterator();
		//while(ite.hasNext()) {			
			
			//MovieVO movie =ite.next();
			// MOVIERATE 테이블, movieid로 userid의 movierate(평점) 불러오기
			
			//System.out.println(rateList);
			/*// Inner Hash 선언
			HashMap<String, Double> inner = new HashMap<String, Double>();
			Iterator<MovieRateVO> iteR= rateList.iterator();
			while(iteR.hasNext()) {
				MovieRateVO rate =iteR.next();
				inner.put(rate.getUserid(),rate.getMovierate());
			}*/
			
			
		//}
		
		return "/suggest/suggestList";
	}
}
