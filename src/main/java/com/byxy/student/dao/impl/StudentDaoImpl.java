package com.byxy.student.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.byxy.student.dao.StudentDao;
import com.byxy.student.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> find() {
		// 使用Criteria
		return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
		// 使用HQL
		// return sessionFactory.getCurrentSession().createQuery("from Student").list();

	}

	@Override
	public void add(Student p) {
		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public Student getById(String pid) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, pid);

	}

	@Override
	public void update(Student p) {
		sessionFactory.getCurrentSession().update(p);
	}

	@Override
	public void deleteById(String pid) {
		Student p = new Student();
		p.setPid(pid);
		sessionFactory.getCurrentSession().delete(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> find(int curPage, int pageCount) {
		// 使用Criteria
		return sessionFactory.getCurrentSession().createCriteria(Student.class).setMaxResults(pageCount)
				.setFirstResult((curPage - 1) * pageCount).list();
		// 使用HQL
		// return sessionFactory.getCurrentSession().createQuery("from
		// Student").setMaxResults(pageCount)
		// .setFirstResult((curPage - 1) * pageCount).list();

	}

	@Override
	public int count() {
		// 使用Criteria
		long l = (Long) sessionFactory.getCurrentSession().createCriteria(Student.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		// 使用HQL
		// long l = (Long) sessionFactory.getCurrentSession().createQuery("Select
		// count(u) from Student u").uniqueResult();
		return (int) l;
	}


}
