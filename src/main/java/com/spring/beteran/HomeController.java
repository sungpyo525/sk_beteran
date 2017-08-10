package com.spring.beteran;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.beteran.user.model.vo.UserVO;
import com.spring.beteran.user.service.UserService;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;
import kr.or.kobis.kobisopenapi.consumer.soap.movie.MovieAPIServiceImplService;
import kr.or.kobis.kobisopenapi.consumer.soap.movie.MovieInfoResult;

@Controller
public class HomeController {
	
	public String getToday() {
		
		Calendar cal = new GregorianCalendar();
	    cal.add(Calendar.DATE, -1);

	    String y_year = Integer.toString(cal.get(Calendar.YEAR));
        String y_month = Integer.toString(cal.get(Calendar.MONTH)+1);
        String y_date = Integer.toString(cal.get(Calendar.DATE));
	    	
	    if(y_month.length() ==1 ) y_month = "0" +y_month; //month 3 => 03
        if(y_date.length() ==1 ) y_date = "0" +y_date;  //day 7=> 07


        String yesterday = y_year + y_month + y_date;

	    return yesterday;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping(value = "/main.bt", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws OpenAPIFault, Exception {
		System.out.println("Ctrl Home");
		System.out.println("Ctrl Test list");
		ArrayList<UserVO> list = service.list();
		model.addAttribute("lists",list);
		
		
		//찬호 메인 페이지 kobis API로부터 박스오피스 데이터 보기
		// 발급키
		String key = "95a0c5b77bf70ad87df5e6bbcc0331ab";

		// KOBIS 오픈 API Rest Client를 통해 호출
		KobisOpenAPIRestService kobisService = new KobisOpenAPIRestService(key);
		
		//오늘 연월일 구하기
		String today = getToday();
		System.out.println("오늘 연원일 : " + today);
		
		// 일일 박스오피스 서비스 호출 (boolean isJson, String targetDt, String itemPerPage,String multiMovieYn, String repNationCd, String wideAreaCd)
	    String dailyResponse = kobisService.getDailyBoxOffice(true,today,null,null,null,null);
	    
	    // Json 라이브러리를 통해 Handling
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> dailyResult = mapper.readValue(dailyResponse, HashMap.class);
	    
		model.addAttribute("dailyResult", dailyResult);

		//movieCd로 영화 받아오기
		/*String movieCd = "123";
		MovieInfoResult movieInfoResult = new MovieAPIServiceImplService().getMovieAPIServiceImplPort().searchMovieInfo(key, movieCd);
		model.addAttribute("movieInfoResult",movieInfoResult);	
		*/
		return "home" ;
	}
	
}
