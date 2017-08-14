package com.spring.beteran.boardreview.ctrl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.beteran.boardreview.model.vo.BoardreviewVO;
import com.spring.beteran.boardreview.service.BoardreviewService;
import com.spring.beteran.boardreview.util.vo.BoardreviewSearchVO;
import com.spring.beteran.movie.model.vo.MovieVO;
import com.spring.beteran.movie.service.MovieService;
import com.spring.beteran.reviewlike.model.vo.ReviewLikeVO;
import com.spring.beteran.user.model.vo.UserVO;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/board")
public class BoardreviewCtrl {

	@Resource(name = "boardService") // 자원으로 가져오는데 name 으로 가져온다, 의존성을 띤 보드서비스에서 가져옴
	private BoardreviewService service;
	
	@Resource(name="movieService")
	private MovieService movieService;

	@RequestMapping("/list.bt")
	public String list(UserVO user ,Model model) {
		System.out.println("Ctrl list");
		ArrayList<BoardreviewVO> list = service.list(user);
		model.addAttribute("lists", list);
		return "board/listAll";

	}

	@RequestMapping("/search.bt")
	@ResponseBody // 컨트롤거치지바로 응답할수 있게 함, 리스폰스 바디 붙으면 비동기식임
	public ArrayList<BoardreviewVO> search(BoardreviewSearchVO search) {
		System.out.println("Ctrl search");
		System.out.println("type :  " + search.getSearchType());
		System.out.println("type :  " + search.getSearchKeyword());
		ArrayList<BoardreviewVO> list = service.search(search);

		return list;

	}


	@RequestMapping("/boardForm.bt")
	public String form(MovieVO movie, Model model) {
		System.out.println("Ctrl form");
		//System.out.println(movie.getMoviename());
		//System.out.println(movie.getMoviedate());
		
		model.addAttribute("moviename", movie.getMoviename());
		model.addAttribute("moviedate", movie.getMoviedate());
		model.addAttribute("moviedirector", movie.getMoviedirector());
		
		return "board/register";

	}

	@RequestMapping("/register.bt") // 레지스터 설정
	public String register(BoardreviewVO board, MovieVO movie) { // 매개변수 지정하면 알아서 세터 찾아감
		System.out.println("Ctrl register");
		
		
		
		System.out.println(movie.getMoviename());
		System.out.println(movie.getMoviedate());
		System.out.println(movie.getMoviedirector());
		

		// check movie table : 해당 영화정보가 없으면 insert해준다
		MovieVO checkMovie = movieService.selectRow(movie);
		System.out.println("영화테이블에 데이터가 있나요?? 영화 이름?" + checkMovie.getMoviename());
		if (checkMovie.getMoviename() == "NoMovie") {
			int ch = movieService.insert(movie);
			System.out.println("insert 결과 : " + ch);
		}
		
		
		// 영화이름과 년도로 movieid 얻기
		int getId = movieService.getMovieId(movie);

		board.setMovieid(getId);

		int flag = service.register(board);

		return "redirect:/board/list.bt";

	}

	@RequestMapping("/modifyForm.bt")
	public String modify(BoardreviewVO board, Model model) {
		System.out.println("Ctrl modify");
		BoardreviewVO resource = service.modifyForm(board);
		model.addAttribute("boardreviewVO", resource);
		return "board/modify";

	}

	@RequestMapping("/modify.bt")
	public String modify(BoardreviewVO board) {
		System.out.println("Ctrl modify");
		int resource = service.modify(board);

		return "redirect:/board/list.bt";

	}

	@RequestMapping("/delete.bt")
	public String delete(BoardreviewVO board) {
		System.out.println("Ctrl delete");
		int resource = service.delete(board);
		return "redirect:/board/list.bt";
	}
	
	
	@RequestMapping("/insertLike.bt")
	@ResponseBody
	public int insertLike(ReviewLikeVO like) {
		int result=0;
		System.out.println("Ctrl insertLike");
		result=service.insertLike(like);
		return result;
	}
	
	@RequestMapping("/selectCountLike.bt")
	@ResponseBody
	public int selectCountLike(ReviewLikeVO like) {
		int count;
		System.out.println("Ctrl selectCountLike");
		ReviewLikeVO result =service.selectCountLike(like);
		if(result==null) {
			count=0;
		}else {
			count = result.getCountlike();
		}
		return count;
	}
	
	@RequestMapping("/showLikeBtn.bt")
	@ResponseBody
	public int showLikeBtn(ReviewLikeVO like) {
		System.out.println("Ctrl showLikeBtn");
		int result;
		ReviewLikeVO vo= service.showLikeBtn(like);
		if(vo == null) {
			result=1;
		}else {
			result=0;
		}return result;
	}
	
	@RequestMapping("/deleteLike.bt")
	@ResponseBody
	public int deleteLike(ReviewLikeVO like) {
		System.out.println("Ctrl deleteLike");
		int result=service.deleteLike(like);
		return result;
	}
	
	@RequestMapping("/findMovieId.bt")
	@ResponseBody
	public int findMovieId(MovieVO movie) {
		System.out.println("Ctrl findMovieId");
		MovieVO result=service.findMovieId(movie);
		System.out.println(result.getMovieid());
		return result.getMovieid();
		
	}
	
	@RequestMapping("/goReview.bt")
	public String goReview(BoardreviewVO review, Model model) {
		System.out.println("Ctrl goReview");
		ArrayList<BoardreviewVO> list = service.goReview(review);
		/*Iterator<BoardreviewVO> ite= list.iterator();
		while(ite.hasNext()) {
			BoardreviewVO iteTemp=ite.next();
			System.out.println(iteTemp.getRvcontent());
			iteTemp.getRvcontent().replaceAll("\\n", "<br>");
		}*/
		model.addAttribute("allLists",list);
		model.addAttribute("moviename",list.get(0).getMoviename());
		return "/board/goReview";
	}

}
