package com.byxy.student.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.byxy.student.dao.StudentDao;
import com.byxy.student.entity.Student;
import com.byxy.student.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource
	private StudentDao personDao ;
	@Override
	public Student getLoginStudent(Student p) {
		return personDao.getById(p.getPid());
	}

}
