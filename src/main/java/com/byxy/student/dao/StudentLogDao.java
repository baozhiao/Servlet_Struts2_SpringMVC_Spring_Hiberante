package com.byxy.student.dao;

import java.util.List;

import com.byxy.student.entity.Student;
import com.byxy.student.entity.StudentLog;

public interface StudentLogDao {

	/**
	 * 统计记录数
	 * 
	 * @return
	 */
	int count();
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
	 * 保存记录
	 * 
	 * @param p
	 */
	void add(StudentLog p);

}