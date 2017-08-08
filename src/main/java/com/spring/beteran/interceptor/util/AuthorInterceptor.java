package com.spring.beteran.interceptor.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorInterceptor extends HandlerInterceptorAdapter {
	

	public void saveDestination(HttpServletRequest request) {
		String uri=request.getRequestURI();
		String query= request.getQueryString();
		System.out.println(">> Auth interceptor saveDestination()");
		System.out.println("uri : query = "+uri+" : "+query);
		if(query==null || query.equals("null")) {
			query="";
		}else {
			query="?"+query;
		}
		HttpSession session = request.getSession();
		session.setAttribute("saveDestination", (uri+query));
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(">> Author Interceptor pre");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("loginUser");
		String path = "/user/loginPost.bt";
		if(obj==null) {
			response.sendRedirect(path);
			saveDestination(request);
			return false;
		}
		return true;
	}

}
