package com.byxy.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class File {

	@Id
	@Column(length = 255, name = "file_Id")
	private int file_Id;
	//
	private String file_Name;
	//
	private String file_path;

	public void setFile_Id(int file_Id) {
		this.file_Id = file_Id;
	}

	public void setFile_Name(String file_Name) {
		this.file_Name = file_Name;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public int getFile_Id() {
		return file_Id;
	}

	public String getFile_Name() {
		return file_Name;
	}

	public String getFile_path() {
		return file_path;
	}

	@Override
	public String toString() {
		return "File{" +
				"file_Id='" + file_Id + '\'' +
				", file_Name='" + file_Name + '\'' +
				", file_path='" + file_path + '\'' +
				'}';
	}
}
