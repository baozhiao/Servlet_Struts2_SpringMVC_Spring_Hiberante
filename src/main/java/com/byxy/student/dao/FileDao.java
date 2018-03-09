package com.byxy.student.dao;

import com.byxy.student.entity.File;

import java.util.List;

public interface FileDao {

    public void addFile(File file);

    public List<File> findFileList();

    public File findFileById(int id);

}
