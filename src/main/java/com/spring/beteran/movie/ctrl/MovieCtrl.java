package com.spring.beteran.movie.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movie.model.vo.SearchMovieVO;
import com.spring.beteran.movie.service.MovieService;
import com.spring.beteran.movierate.model.vo.MovieRateVO;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;

@Controller
@RequestMapping("/movie")
public class MovieCtrl {
	
	@Resource(name="movieService")
	private MovieService service;

	@RequestMapping("/boxOffice.bt")
	public String boxOffice(Model model) throws OpenAPIFault, Exception {
		
		// 발급키
		String key = "95a0c5b77bf70ad87df5e6bbcc0331ab";

		// KOBIS 오픈 API Rest Client를 통해 호출
		KobisOpenAPIRestService kobisService = new KobisOpenAPIRestService(key);
		
		// 일일 박스오피스 서비스 호출 (boolean isJson, String targetDt, String itemPerPage,String multiMovieYn, String repNationCd, String wideAreaCd)
	    String dailyResponse = kobisService.getDailyBoxOffice(true,null,null,null,null,null);
	    
	    // Json 라이브러리를 통해 Handling
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> dailyResult = mapper.readValue(dailyResponse, HashMap.class);
	    
		model.addAttribute("dailyResult", dailyResult);
		return null;
	}

	@RequestMapping("/search.bt")
	public String search(SearchMovieVO movie, Model model) {
		
		String movieName = movie.getMovieName();
		
		String directorName = null;
		directorName = movie.getDirectorName();
		
		System.out.println(movieName);
		
		//발급키
		String key = "95a0c5b77bf70ad87df5e6bbcc0331ab";
		
		//KOBIS 오픈 API Rest Client를 통해 호출
		KobisOpenAPIRestService kobisService = new KobisOpenAPIRestService(key);
		
		// 영화코드조회 서비스 호출 (boolean isJson, String curPage, String itemPerPage,String movieNm, String directorNm, String openStartDt, String openEndDt,String prdtStartYear, String prdtEndYear, String repNationCd, String movieTypeCdArr)
	    String movieCdResponse = null;
		try {
			movieCdResponse = kobisService.getMovieList(true, null, "100", movieName, directorName, null, null, null, null, null, null);
		} catch (OpenAPIFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		// Json 라이브러리를 통해 Handling
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> result = new HashMap<>();
		try {
			result = mapper.readValue(movieCdResponse, HashMap.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(result);
		 
		//System.out.println(result.get("movieList"));
		model.addAttribute("lists", result);
		
		
		
		return "movie/searchList";
	}
	
	@RequestMapping("/searchOption.bt")
	@ResponseBody
	public HashMap<String,Object> searchOption(SearchMovieVO movie) throws OpenAPIFault, Exception {
		System.out.println("여러가지 옵션주고 영화찾는 부분 : 컨트롤러 왔다");
		System.out.println("여기는 비동기로 보여줌");
		
		// 발급키
		String key = "95a0c5b77bf70ad87df5e6bbcc0331ab";

		// KOBIS 오픈 API Rest Client를 통해 호출
		KobisOpenAPIRestService kobisService = new KobisOpenAPIRestService(key);
		
		// 영화코드조회 서비스 호출 (boolean isJson, curPage, itemPerPage, movieNm, directorNm, openStartDt, openEndDt, prdtStartYear, prdtEndYear, repNationCd, movieTypeCdArr)
		String movieCdResponse = kobisService.getMovieList(true, null, "100", movie.getMovieName(), movie.getDirectorName(), movie.getOpenStartDate(), movie.getOpenEndDate(), null, null, null, null);
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> result = new HashMap<>();
		
		result = mapper.readValue(movieCdResponse, HashMap.class);
		
		return result;
	}
	
	@RequestMapping("/getPicture.bt")
	@ResponseBody
	public HashMap<String,Object> getPicture(String movieName) throws JsonParseException, JsonMappingException, IOException{
		NaverApi naver = new NaverApi();
		
		System.out.println(movieName);
		
		String naverJson = naver.getNaverMovieJson(movieName);
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> result = new HashMap<>();
		
		result = mapper.readValue(naverJson, HashMap.class);
		System.out.println(result);
		
		return result;
	
	}
	
	@RequestMapping("/movieRate.bt")
	public String list(Model model) {
		System.out.println("Ctrl Movielist");
		ArrayList<MovieVO> list = service.list();
		ArrayList<MovieRateVO> listRate = service.listRate();
		model.addAttribute("movieRatelists", listRate);
		model.addAttribute("movielists", list);
		
		return "movie/movielist";
	}

	
	
}
