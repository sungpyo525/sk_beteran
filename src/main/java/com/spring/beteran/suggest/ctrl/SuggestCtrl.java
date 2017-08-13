package com.spring.beteran.suggest.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String suggestList() throws Exception{
		System.out.println("Ctrl suggestList");
		
		HashMap<Integer, HashMap<String, Double>> outer = new HashMap<>();
		
		ArrayList<MovieRateVO> rateList = service.rateList();

		Iterator<MovieRateVO> ite = rateList.iterator();
		while(ite.hasNext()) {
			MovieRateVO rate = ite.next();
			HashMap<String, Double> inner = new HashMap<String, Double>();
			inner.put(rate.getUserid(), rate.getMovierate());
			try {
				if(outer.get(rate.getMovieid()) != null) {
					HashMap<String, Double> value = outer.get(rate.getMovieid());
					value.putAll(inner);
					outer.put(rate.getMovieid(), value);
				}else {
					HashMap<String, Double> value =new HashMap<>();
					value.put(rate.getUserid(), rate.getMovierate());
					outer.put(rate.getMovieid(), value);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
		}
		
		
		
		// 확인용 디버그 코드 입니다. 지우셔도 괜찮아요
		System.out.print("<<DebugCode : 해쉬 맵 테스트 출력>>");
		for(int key : outer.keySet()) {
			System.out.println();
			System.out.print("movieid:"+key+" ");
			System.out.print("{");
			for(String innerKey :outer.get(key).keySet()) {
				System.out.print("["+innerKey+", "+outer.get(key).get(innerKey)+"] ");
			}
			System.out.print("}");
		}
		// 여기까지
		
		
		return "/suggest/suggestList";
	}
}
