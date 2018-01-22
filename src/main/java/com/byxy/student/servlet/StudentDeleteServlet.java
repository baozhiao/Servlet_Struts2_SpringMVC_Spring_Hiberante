package com.byxy.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.byxy.student.service.StudentService;

@WebServlet("/servlet/std/delete")
public class StudentDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentService studentService;

	// Servlet不支持Spring 的自动注入，需要手动
	@Override
	public void init() throws ServletException {

		super.init();
		if (null == studentService) {
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			studentService = (StudentService) ctx.getBean(StudentService.class);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pid = req.getParameter("pid");
		if (pid != null && !"".equals(pid))
			studentService.deleteById(pid);
		resp.sendRedirect("list");
	}
}
