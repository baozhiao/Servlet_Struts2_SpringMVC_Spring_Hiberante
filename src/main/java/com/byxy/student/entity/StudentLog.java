package com.byxy.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentLog {
	@Id
	private String id;

	private String module;

	private String method;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public StudentLog(String id, String module, String method) {
		super();
		this.id = id;
		this.module = module;
		this.method = method;
	}

	public StudentLog() {
		super();
	}

}
