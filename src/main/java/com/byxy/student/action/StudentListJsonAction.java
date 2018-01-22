package com.byxy.student.action;

import javax.annotation.Resource;

import com.byxy.student.service.StudentLogService;
import com.byxy.student.util.MyPage;
import com.opensymphony.xwork2.ActionSupport;

public class StudentListJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer draw;
	private Integer length;
	private MyPage page;
	@Resource
	private StudentLogService personLogService;
	// 当前页
	private Integer start;

	public Integer getDraw() {
		return draw;
	}

	public Integer getLength() {
		return length;
	}

	public MyPage getPage() {
		return page;
	}

	public Integer getStart() {
		return start;
	}

	/*
	 * 列表Action
	 */
	public String list() {
		page = personLogService.getMyPage(draw, start, length);
		return SUCCESS;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public void setPage(MyPage page) {
		this.page = page;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
}
