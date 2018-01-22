package com.byxy.student.action;

import javax.annotation.Resource;

import com.byxy.student.entity.Student;
import com.byxy.student.service.StudentService;
import com.byxy.student.util.Pager;
import com.opensymphony.xwork2.ActionSupport;

public class StudentListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	StudentService studentService;
	// 当前页
	private String curPage;
	// 行数
	private String pageCount;
	// 列表集合
	private Pager<Student> pager;

	/*
	 * 列表Action
	 */
	public String list() {
		pager = studentService.getPage(curPage, pageCount);
		System.out.println(pager);
		return SUCCESS;
	}

	public Pager<Student> getPager() {
		return pager;
	}

	public void setPager(Pager<Student> pager) {
		this.pager = pager;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
}
