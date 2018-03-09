package com.byxy.student.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.byxy.student.entity.Student;
import com.byxy.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	StudentService studentService;

	private String pid;

	private Student person;

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	/*
	 * 删除Action
	 */
	public String delete() {
		if (pid != null && !"".equals(pid))
			studentService.deleteById(pid);
		return SUCCESS;
	}

	/*
	 * 修改Action
	 */
	public String update() {
		if ("post".equalsIgnoreCase(ServletActionContext.getRequest().getMethod())) {
			if (person != null && person.getPid() != null && !"".equals(person.getPid())) {
				studentService.updatePerson(person);
			}
			return SUCCESS;
		} else {
			if (pid != null && !"".equals(pid)) {
				person = studentService.getById(pid);
			}
			return "update";
		}
	}

	/*
	 * 增加Action
	 */
	public String add() {
		if ("post".equalsIgnoreCase(ServletActionContext.getRequest().getMethod())) {
			if (person != null) {
				studentService.addPerson(person);
				System.out.println("222222222222222222222222222222222222222222222222222222222222222222222222222");
			}
			return SUCCESS;
		} else {
			return "add";
		}
	}
}
