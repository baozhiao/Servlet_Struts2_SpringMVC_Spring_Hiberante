package com.byxy.student.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.byxy.student.entity.Student;
import com.byxy.student.service.StudentService;
import com.byxy.student.util.Pager;

@Controller
@RequestMapping("springmvc/std")
public class StudentController {

	@Resource
	StudentService studentService;

	/*
	 * 由于springmvc不支持person.pid=xxxx person.name=xxx等传值操作，需要加入以下设置 @InitBinder
	 * & @ModelAttribute，而Struts2则完美支持。Springmvc支持pid=xxx&name=xxx传值，以对象接收，
	 * 而Struts2需要使用驱动模型（ModelDriven）才能支持
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("person.");
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(String curPage, String pageCount, Model model) {
		Pager<Student> pager = studentService.getPage(curPage, pageCount);
		model.addAttribute("pager", pager);
		return "person/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "person/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student person) {
		studentService.addPerson(person);
		return "redirect:list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(String pid, Model model) {
		Student student = studentService.getById(pid);
		model.addAttribute("person", student);
		return "person/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Student person) {
		studentService.updatePerson(person);
		return "redirect:list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(String pid) {
		studentService.deleteById(pid);
		return "redirect:list";
	}
}
