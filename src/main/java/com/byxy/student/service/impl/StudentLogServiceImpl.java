package com.byxy.student.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.byxy.student.dao.StudentLogDao;
import com.byxy.student.entity.StudentLog;
import com.byxy.student.service.StudentLogService;
import com.byxy.student.util.MyPage;

@Service
@Transactional
public class StudentLogServiceImpl implements StudentLogService {

	@Resource
	private StudentLogDao studentLogDao;

	@Override
	public MyPage getMyPage(int a1, int a2, int a3) {
		MyPage page = new MyPage();
		page.setRecordsTotal(studentLogDao.count());
		page.setDraw(a1 + 1);
		page.setData(studentLogDao.find((a2 - 1 + a3) / a3, a3));
		page.setRecordsFiltered(studentLogDao.count());
		return page;
	}

	@Override
	public void save(StudentLog studentLog) {
		studentLogDao.add(studentLog);
	}

}
