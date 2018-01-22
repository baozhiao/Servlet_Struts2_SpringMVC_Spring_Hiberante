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
import com.byxy.student.service.StudentService;
import com.byxy.student.util.Pager;

@WebServlet("/servlet/std/list")
public class StudentListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentService studentService;

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
		String curPage = req.getParameter("curPage");
		// 行数
		String pageCount = req.getParameter("pageCount");
		// 列表集合
		Pager<Student> pager = studentService.getPage(curPage, pageCount);
		req.setAttribute("pager", pager);
		req.getRequestDispatcher("/WEB-INF/jsp/person/list.jsp").forward(req, resp);
	}

}
