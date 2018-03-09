package com.byxy.student.service.impl;

import com.byxy.student.dao.FileDao;
import com.byxy.student.dao.StudentDao;
import com.byxy.student.entity.File;
import com.byxy.student.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Resource
    private FileDao fileDao ;

    @Override
    public void addFile(File file) {
        fileDao.addFile(file);
    }

    @Override
    public List<File> findFileList() {
        return fileDao.findFileList();
    }

    @Override
    public File findFileById(int id) {
        return fileDao.findFileById(id);
    }


}
