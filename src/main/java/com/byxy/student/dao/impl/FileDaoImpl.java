package com.byxy.student.dao.impl;

import com.byxy.student.dao.FileDao;
import com.byxy.student.entity.File;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class FileDaoImpl implements FileDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void addFile(File file) {

        sessionFactory.getCurrentSession().save(file);
    }

    @Override
    public List<File> findFileList() {
        return sessionFactory.getCurrentSession().createQuery("from File").list();
    }

    @Override
    public File findFileById(int id) {
        return (File) sessionFactory.getCurrentSession().createQuery("from File where file_Id = ?").setParameter(0,id).list().get(0);
    }
}
