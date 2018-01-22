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

@WebServlet("/servlet/std/add")
public class StudentAddServlet extends HttpServlet {

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
		req.getRequestDispatcher("/WEB-INF/jsp/person/add.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pid = req.getParameter("person.pid");
		String cellphone = req.getParameter("person.cellphone");
		String name = req.getParameter("person.name");
		String password = req.getParameter("person.password");
		String address = req.getParameter("person.address");
		String dorm = req.getParameter("person.dorm");
		String remarks = req.getParameter("person.remarks");
		String job = req.getParameter("person.job");
		String relationship = req.getParameter("person.relationship");
		String relationshipPhone = req.getParameter("person.relationshipPhone");
		Student person = new Student(pid, cellphone, name, password, address, dorm, remarks, job, relationship,
				relationshipPhone);
		if (person != null && person.getPid() != null && !"".equals(person.getPid())) {
			studentService.addPerson(person);
		}
		resp.sendRedirect("list");
	}

}
