package com.cssl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器(过滤器)
 * @author TYM
 *
 */
public class MyInterceptor implements HandlerInterceptor {
	
	//请求到达控制器前
	//chain.doFilter() 向后传递请求  init  destroy
	//控制器执行完毕，响应客户端前

	/**
	 * 请求到达控制器前执行
	 * 返回true表示继续传递请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle...");
		return true;
	}

	/**
	 * 控制器执行完毕，响应客户端前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle...");
	}

	/**
	 * 视图渲染完毕后执行，无论是否异常都执行
	 * 收尾工作，释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion...");
	}

	
	
}
