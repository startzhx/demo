package com.cssl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuthorityInterceptor:"+handler);
		String uri=request.getRequestURI();
		System.out.println("uri:"+uri);
		if(uri.endsWith("form1")) {
			return true;
		}
		HttpSession session=request.getSession();
		if(session.getAttribute("empVo")==null) {
			response.sendRedirect("form.jsp");
			return false;
		}
		return true;
	}

}
