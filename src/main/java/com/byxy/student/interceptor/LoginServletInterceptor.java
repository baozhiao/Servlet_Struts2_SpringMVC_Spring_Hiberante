package com.byxy.student.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.byxy.student.entity.Student;

@WebFilter(urlPatterns = "/servlet/*")
public class LoginServletInterceptor implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("++++++++++++++");
		// 通过request对象的方法获取HttpSession对象
		HttpSession session = ((HttpServletRequest) request).getSession();
		// 获取Session对象中的值
		Student login = (Student) session.getAttribute("loginUser");

		String uri = ((HttpServletRequest) request).getRequestURI();
		// 登录页面与开始页面不需要判断登录与否
		if (uri.endsWith("login") || uri.endsWith("index")) {
			// 将资源传递下一个过滤器
			System.out.println("-----------------");
			chain.doFilter(request, response);
		} else if (login == null) {
			// 客户端跳转
			((HttpServletResponse) response)
					.sendRedirect(((HttpServletRequest) request).getContextPath() + "/servlet/login");
		} else {
			// 将资源传递下一个过滤器
			System.out.println("-----------------");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
