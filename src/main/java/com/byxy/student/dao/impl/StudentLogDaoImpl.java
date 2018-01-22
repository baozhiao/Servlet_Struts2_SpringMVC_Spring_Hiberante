package com.byxy.student.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.byxy.student.dao.StudentLogDao;
import com.byxy.student.entity.Student;
import com.byxy.student.entity.StudentLog;

@Repository
public class StudentLogDaoImpl implements StudentLogDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public int count() {
		// 使用Criteria
		long l = (Long) sessionFactory.getCurrentSession().createCriteria(StudentLog.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		// 使用HQL
		// long l = (Long) sessionFactory.getCurrentSession().createQuery("Select
		// count(u) from Student u").uniqueResult();
		return (int) l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> find(int curPage, int pageCount) {
		// 使用Criteria
		return sessionFactory.getCurrentSession().createCriteria(StudentLog.class).setMaxResults(pageCount)
				.setFirstResult((curPage - 1) * pageCount).list();
		// 使用HQL
		// return sessionFactory.getCurrentSession().createQuery("from
		// Student").setMaxResults(pageCount)
		// .setFirstResult((curPage - 1) * pageCount).list();

	}

	@Override
	public void add(StudentLog p) {
		sessionFactory.getCurrentSession().save(p);
	}

}
