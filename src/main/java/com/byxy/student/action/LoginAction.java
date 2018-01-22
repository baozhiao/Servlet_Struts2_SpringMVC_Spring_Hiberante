package com.byxy.student.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.byxy.student.entity.Student;
import com.byxy.student.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Student> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student loginPerson = new Student();

	@Resource
	private LoginService loginService;

	public Student getLoginPerson() {
		return loginPerson;
	}

	@Override
	public Student getModel() {
		return loginPerson;
	}
	/*
	 * 登录
	 */
	public String login() {
		if ("post".equalsIgnoreCase(ServletActionContext.getRequest().getMethod())) {
			if (loginPerson != null && loginPerson.getPid() != null && !"".equals(loginPerson.getPid())) {
				Student p = loginService.getLoginStudent(loginPerson);
				if (p != null && p.getPassword().equals(loginPerson.getPassword())) {
					ServletActionContext.getRequest().getSession().setAttribute("loginUser", p);
					return "index";
				}
			}
			return LOGIN;
		} else {

			return LOGIN;
		}
	}

	public void setLoginPerson(Student loginPerson) {
		this.loginPerson = loginPerson;
	}
	/*
	 * 退出
	 */
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
		return SUCCESS;
	}
}
