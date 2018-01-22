package com.byxy.student.service;

import java.util.List;

import com.byxy.student.entity.Student;
import com.byxy.student.util.Pager;

public interface StudentService {

	/**
	 * 获取分页查询Person对象
	 * 
	 * @param curPage
	 * @param pageCount
	 * @return
	 */
	public List<Student> find(int curPage, int pageCount);

	/**
	 * 获取分页对象
	 * 
	 * @param curPage
	 * @param pageCount
	 * @return
	 */
	public Pager<Student> getPage(String curPage, String pageCount);

	/**
	 * 查询所有Person对象的总数
	 * 
	 * @return
	 */
	public int countAll();

	/**
	 * 查询所有Person对象
	 * 
	 * @return
	 */
	public List<Student> findAll();

	/**
	 * 通过ID查询Person对象
	 * 
	 * @param pid
	 * @return
	 */
	public Student getById(String pid);

	/**
	 * 增加Person对象
	 * 
	 * @param p
	 */
	public void addPerson(Student p);

	/**
	 * 更新Person对象
	 * 
	 * @param p
	 */
	public void updatePerson(Student p);

	/**
	 * 通过ID删除Person对象
	 * 
	 * @param pid
	 */
	public void deleteById(String pid);


}
