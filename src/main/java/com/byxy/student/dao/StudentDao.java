package com.byxy.student.dao;

import java.util.List;

import com.byxy.student.entity.Student;

public interface StudentDao {

	/**
	 * 查询所有记录
	 * 
	 * @return 所有记录
	 */
	List<Student> find();

	/**
	 * 保存记录
	 * 
	 * @param p
	 */
	void add(Student p);

	/**
	 * 通过ID查询记录
	 * 
	 * @param pid
	 * @return
	 */
	Student getById(String pid);

	/**
	 * 更新记录
	 * 
	 * @param p
	 */
	void update(Student p);

	/**
	 * 通过ID删除记录
	 * 
	 * @param pid
	 */
	void deleteById(String pid);

	/**
	 * 分页查询
	 * 
	 * @param curPage
	 *            当前页 （从1开孡的正数）
	 * @param pageCount
	 *            行数（从1开始的正数）
	 * @return
	 */
	List<Student> find(int curPage, int pageCount);

	/**
	 * 统计记录数
	 * 
	 * @return
	 */
	int count();


}