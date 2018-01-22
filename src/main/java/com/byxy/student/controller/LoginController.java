package com.byxy.student.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.byxy.student.entity.Student;
import com.byxy.student.service.LoginService;

@Controller
@RequestMapping("springmvc")
@SessionAttributes({ "loginUser" })
public class LoginController {

	@Resource
	private LoginService loginService;

	/*
	 * 主页
	 */
	@RequestMapping("index")
	public String index() {
		return "system/index";
	}

	/*
	 * 登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "system/login";
	}
	/*
	 * 登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String pid, String password, Model model) {
		Student loginPerson = new Student();
		loginPerson.setPid(pid);
		loginPerson.setPassword(password);
		if (loginPerson != null && loginPerson.getPid() != null && !"".equals(loginPerson.getPid())) {
			Student p = loginService.getLoginStudent(loginPerson);
			if (p != null && p.getPassword().equals(loginPerson.getPassword())) {
				model.addAttribute("loginUser", p);
				return "redirect:index";
			}
			return "system/login";
		} else {
			return "system/login";
		}
	}
	/*
	 * 退出
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		model.asMap().remove("loginUser");
		session.removeAttribute("loginUser");
		return "redirect:login";
	}
}
