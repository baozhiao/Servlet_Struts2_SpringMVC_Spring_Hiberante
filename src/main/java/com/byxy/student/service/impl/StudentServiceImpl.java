package com.byxy.student.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.byxy.student.dao.StudentDao;
import com.byxy.student.entity.Student;
import com.byxy.student.service.StudentService;
import com.byxy.student.util.Pager;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.find();
	}

	@Override
	public void addPerson(Student p) {
		studentDao.add(p);
	}

	@Override
	public Student getById(String pid) {
		return studentDao.getById(pid);
	}

	@Override
	public void updatePerson(Student p) {
		studentDao.update(p);
	}

	@Override
	public void deleteById(String pid) {
		studentDao.deleteById(pid);
	}

	@Override
	public List<Student> find(int curPage, int pageCount) {
		return studentDao.find(curPage, pageCount);
	}

	@Override
	public int countAll() {
		return studentDao.count();
	}

	@Override
	public Pager<Student> getPage(String strCurPage, String strPageCount) {

		Pager<Student> page = new Pager<Student>();

		if (strCurPage == null || strPageCount == null) {
			strCurPage = "1";
			strPageCount = "5";
		}
		// 计算总页数，修正当前页的值
		int countAll = studentDao.count();
		int curPage = Integer.parseInt(strCurPage);
		int pageCount = Integer.parseInt(strPageCount);
		int totalPage = (countAll + pageCount - 1) / pageCount;
		if (curPage <= 0) {
			curPage = 1;
		}
		if (curPage > totalPage) {

			if (totalPage > 0)
				curPage = totalPage;
			else
				curPage = 1;
		}

		List<Student> persons = studentDao.find(curPage, pageCount);
		page.setLists(persons);
		page.setCurPage(curPage);
		page.setPageCount(pageCount);

		return page;
	}
}
