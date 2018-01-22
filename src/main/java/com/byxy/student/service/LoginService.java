package com.byxy.student.service;

import com.byxy.student.entity.Student;

public interface LoginService {

	/**
	 * 查检登录用户
	 * @param p
	 * @return
	 */
	Student getLoginStudent(Student p);
}
