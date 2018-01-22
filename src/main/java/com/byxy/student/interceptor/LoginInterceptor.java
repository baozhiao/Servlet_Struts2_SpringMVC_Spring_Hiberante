package com.byxy.student.interceptor;

import java.util.Map;

import com.byxy.student.action.LoginAction;
import com.byxy.student.entity.Student;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Object action = actionInvocation.getAction();
		if (action instanceof LoginAction) {
			System.out.println("exit check login, because this is login action.");
			return actionInvocation.invoke();
		}

		// 确认Session中是否存在LOGIN
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		Student login = (Student) session.get("loginUser");
		if (login != null) {
			// 存在的情况下进行后续操作。
			System.out.println("already login!");
			return actionInvocation.invoke();
		} else {
			// 否则终止后续操作，返回LOGIN
			System.out.println("no login, forward login page!");
			return "login";
		}

	}

}
