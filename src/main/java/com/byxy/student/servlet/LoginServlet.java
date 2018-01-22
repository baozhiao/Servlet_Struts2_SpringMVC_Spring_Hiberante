package com.byxy.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.byxy.student.entity.Student;
import com.byxy.student.service.LoginService;

@WebServlet("/servlet/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;

	// Servlet不支持Spring 的自动注入，需要手动
	@Override
	public void init() throws ServletException {

		super.init();
		if (null == loginService) {
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			loginService = (LoginService) ctx.getBean(LoginService.class);
		}
	}
	/*
	 * 登录
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/system/login.jsp").forward(req, resp);
	}
	/*
	 * 登录
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pid = req.getParameter("pid");
		String password = req.getParameter("password");
		Student loginPerson = new Student();
		loginPerson.setPid(pid);
		loginPerson.setPassword(password);
		if (loginPerson.getPid() != null && !"".equals(loginPerson.getPid())) {

			Student p = loginService.getLoginStudent(loginPerson);
			if (p != null && p.getPassword().equals(loginPerson.getPassword())) {
				req.getSession().setAttribute("loginUser", p);
				resp.sendRedirect("index");
			} else {
				resp.sendRedirect("login");
			}
		} else {
			resp.sendRedirect("login");
		}
	}

}
