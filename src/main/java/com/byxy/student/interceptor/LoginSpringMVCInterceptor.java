package com.byxy.student.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.byxy.student.entity.Student;

public class LoginSpringMVCInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("===========HandlerInterceptor1 afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("===========HandlerInterceptor1 postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("===========HandlerInterceptor1 preHandle");
		Student u = (Student) request.getSession().getAttribute("loginUser");
		if (u == null) {
			String uri = request.getContextPath();
			response.sendRedirect(uri + "/springmvc/login");
			return false;
		}
		return true;
	}

}
