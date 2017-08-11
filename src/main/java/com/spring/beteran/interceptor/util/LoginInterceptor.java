package com.spring.beteran.interceptor.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	public String  checkDestination(HttpServletRequest request) {
		String path=null;
		HttpSession session=request.getSession();
		path=(String)session.getAttribute("saveDestination");
		session.removeAttribute("saveDestination");
		System.out.println(">> CheckDest : "+path);
		return path;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(">> interceptor Login post");
		HttpSession session = request.getSession();
		ModelMap model = modelAndView.getModelMap();
		 
		String dest = checkDestination(request);
		String path = (dest!=null) ? dest : "/main.bt";
		Object obj = model.get("loginUser");
		if(obj!=null) {
			 session.setAttribute("loginUser", obj);
			 response.sendRedirect(path);
		}
	}
}
