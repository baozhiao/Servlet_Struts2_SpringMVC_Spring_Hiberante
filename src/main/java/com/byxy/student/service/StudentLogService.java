package com.byxy.student.service;

import com.byxy.student.entity.StudentLog;
import com.byxy.student.util.MyPage;

public interface StudentLogService {

	
	public MyPage getMyPage(int a1,int a2,int a3);
	/**
	 * 增加对象
	 * 
	 * @param
	 */

	public void save(StudentLog studentLog);

}
