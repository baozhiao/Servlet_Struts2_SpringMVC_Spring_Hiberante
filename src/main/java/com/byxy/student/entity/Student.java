package com.byxy.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Student {
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", cellphone=" + cellphone + ", name=" + name + ", password=" + password
				+ ", address=" + address + ", dorm=" + dorm + ", remarks=" + remarks + ", job=" + job
				+ ", relationship=" + relationship + ", relationshipPhone=" + relationshipPhone + "]";
	}

	// 
	@Id
	@Column(length = 255, name = "pid")
	private String pid;
	//
	private String cellphone;
	// 
	private String name;
	// 
	private String password;
	// 
	private String address;
	// 
	private String dorm;
	// 
	private String remarks;
	private String job;
	private String relationship;
	private String relationshipPhone;

	public Student() {
		super();
	}

	public Student(String pid, String cellphone, String name, String password, String address, String dorm,
			String remarks, String job, String relationship, String relationshipPhone) {
		super();
		this.pid = pid;
		this.cellphone = cellphone;
		this.name = name;
		this.password = password;
		this.address = address;
		this.dorm = dorm;
		this.remarks = remarks;
		this.job = job;
		this.relationship = relationship;
		this.relationshipPhone = relationshipPhone;
	}

	public String getPid() {
		System.out.println("hryid");
		return pid;
	}

	public void setPid(String pid) {
		System.out.println("Pid");
		this.pid = pid;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRelationshipPhone() {
		return relationshipPhone;
	}

	public void setRelationshipPhone(String relationshipPhone) {
		this.relationshipPhone = relationshipPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		return true;
	}
}
