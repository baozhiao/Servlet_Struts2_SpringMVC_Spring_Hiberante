package com.byxy.student.service;

import com.byxy.student.entity.File;

import java.util.List;

public interface FileService {

    public void addFile(File file);

    public List<File> findFileList();

    public File findFileById(int id);

}
