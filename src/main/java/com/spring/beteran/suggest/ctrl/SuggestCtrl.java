package com.spring.beteran.suggest.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movie.service.MovieService;
import com.spring.beteran.movierate.model.vo.MovieRateVO;
import com.spring.beteran.movierate.service.MovieRateService;
import com.spring.beteran.suggest.model.vo.PredictedRateVO;
import com.spring.beteran.suggest.service.SuggestService;
import com.spring.beteran.user.model.vo.SimUserVO;
import com.spring.beteran.user.model.vo.UserVO;




@Controller
@RequestMapping("/suggest")
public class SuggestCtrl {
	
	@Resource(name="suggestService")
	private SuggestService service;
	
	@Resource(name="movieRateService")
	private MovieRateService userService;
	
	
	@Resource(name="movieService")
	private MovieService movieService;
	
	@RequestMapping("/recommendMovie.bt")
	public String recommendMovie(UserVO user, Model model) throws Exception {
		
		HashMap<Integer, HashMap<String, Double>> outerMovie = new HashMap<>(); 
		outerMovie = dataReshapeItemBased();
		
		HashMap<String, HashMap<Integer, Double>> outerUser = new HashMap<>(); 
		outerUser = dataReshapeUserBased();
		
		RecommendFromHashMap test = new RecommendFromHashMap();
		HashMap<Integer, HashMap<Integer,Double>> baseDataMovieSim = test.similarItems(outerMovie);
		
		System.out.println(baseDataMovieSim.toString());
		ArrayList<PredictedRateVO> finalData = test.recommendMovie(user.getUserid(), outerUser, baseDataMovieSim); //유저에 대한 모든영화 예상 평점
		
		for(PredictedRateVO ary : finalData) {
			System.out.println("	얍 예상 평점list" + ary.getMovieid()+" : "+ary.getRate());
		}
		
	
		ArrayList<PredictedRateVO> finalResult = new ArrayList<>();
		for(PredictedRateVO vo : finalData) {
			if(!outerUser.get(user.getUserid()).keySet().contains(vo.getMovieid()) ) {
				System.out.println("평가하지 않은 영화는 ? "+vo.getMovieid());
				MovieVO movie = new MovieVO();
				movie.setMovieid(vo.getMovieid());
				String moviename = movieService.getMovieName(movie);
				System.out.println(moviename);
				vo.setMoviename(moviename);
				finalResult.add(vo);
			}
		}
	
		model.addAttribute("recommendList", finalResult);
		
		return "/suggest/recommendList";
	}
	
	
	@RequestMapping("/suggestList.bt")
	public String suggestList(UserVO user, Model model) throws Exception{
		System.out.println("Ctrl suggestList");
		
		///////
		
		HashMap<String, HashMap<Integer, Double>> outerUser = new HashMap<>(); 
		outerUser = dataReshapeUserBased();

		/////reshapeUserBased - outerUser
		
		// 확인용 디버그 코드 입니다. 지우셔도 괜찮아요
		/*System.out.print("<<DebugCode : 해쉬 맵 테스트 출력>>");
		for(int key : outerMovie.keySet()) {
			System.out.println();
			System.out.print("movieid:"+key+" ");
			System.out.print("{");
			for(String innerKey :outerMovie.get(key).keySet()) {
				System.out.print("["+innerKey+", "+outerMovie.get(key).get(innerKey)+"] ");
			}
			System.out.print("}");
		}*/
		// 여기까지
		
		System.out.println("얍얍얍 추천 test 중");
		
		
		
		RecommendFromHashMap_UserBased test2 = new RecommendFromHashMap_UserBased();
		
		//HashMap<Integer, HashMap<Integer,Double>> baseDataMovieSim = test.similarItems(outerMovie);
		HashMap<String, HashMap<String,Double>> baseDataUserSim = test2.similarItems(outerUser);
		
		System.out.println(baseDataUserSim.toString());
		
	
		HashMap<String,Double> userSimList = baseDataUserSim.get(user.getUserid()); //로그인한 유저의 유사도(user) 해시맵
		//여기부터 계산한 데이터 심기
		SimUserVO firstSimUser = new SimUserVO("a", 0.0); //가장 유사도 높은 유저의 VO만들기
		for(String key : userSimList.keySet()) {
			double similarity = userSimList.get(key);
			if(firstSimUser.getSimilarity() < similarity) {
				firstSimUser = new SimUserVO(key, similarity);
			}
		}
		model.addAttribute("firstSimUser", firstSimUser);
		
		
		UserVO simUser = new UserVO();
		simUser.setUserid(firstSimUser.getUserid());
		//// 내 평점 리스트와 가장 유사한 유저 평점정보 보여주기
		ArrayList<MovieRateVO> listSim = userService.listRate(simUser);
		ArrayList<MovieRateVO> listMe = userService.listRate(user);
		model.addAttribute("listSim", listSim); // 서비스로직의 결과를 model객체에 담아 jsp에서 사용할 수있게
		
		
		JSONArray jary = new JSONArray(listSim);
		model.addAttribute("listSimJson", jary.toString()); // 서비스로직의 결과를 model객체에 담아 jsp에서 사용할 수있게
		
		model.addAttribute("movieRatelists", listMe);
		
		
		
		
		System.out.println(userSimList);
		
		System.out.println(firstSimUser.getUserid());
		return "/suggest/suggestList";
	}
	
	public HashMap<Integer, HashMap<String, Double>> dataReshapeItemBased(){
	
		HashMap<Integer, HashMap<String, Double>> outerMovie = new HashMap<>();
		
		ArrayList<MovieRateVO> rateList = service.rateList();
		/////
		Iterator<MovieRateVO> ite = rateList.iterator();
		while(ite.hasNext()) {
			MovieRateVO rate = ite.next();
			HashMap<String, Double> inner = new HashMap<String, Double>();
			inner.put(rate.getUserid(), rate.getMovierate());
			try {
				if(outerMovie.get(rate.getMovieid()) != null) {
					HashMap<String, Double> value = outerMovie.get(rate.getMovieid());
					value.putAll(inner);
					outerMovie.put(rate.getMovieid(), value);
				}else {
					HashMap<String, Double> value =new HashMap<>();
					value.put(rate.getUserid(), rate.getMovierate());
					outerMovie.put(rate.getMovieid(), value);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
		}///////reshapeItemBased - outerMovie
		return outerMovie;
	}
	
	public HashMap<String, HashMap<Integer, Double>> dataReshapeUserBased(){
		ArrayList<MovieRateVO> rateList = service.rateList();
		Iterator<MovieRateVO> ite2 = rateList.iterator();
		HashMap<String, HashMap<Integer, Double>> outerUser = new HashMap<>();
		
		while (ite2.hasNext()) {
			MovieRateVO rate = ite2.next();
			HashMap<Integer, Double> inner2 = new HashMap<Integer, Double>();
			inner2.put(rate.getMovieid(), rate.getMovierate());
			try {
				if (outerUser.get(rate.getUserid()) != null) {
					HashMap<Integer, Double> value2 = outerUser.get(rate.getUserid());
					value2.putAll(inner2);
					outerUser.put(rate.getUserid(), value2);
				} else {
					HashMap<Integer, Double> value2 = new HashMap<>();
					value2.put(rate.getMovieid(), rate.getMovierate());
					outerUser.put(rate.getUserid(), value2);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return outerUser;
	}
}
