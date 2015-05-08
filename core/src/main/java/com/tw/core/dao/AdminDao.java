package com.tw.core.dao;

import com.tw.core.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hgwang on 5/7/15.
 */
@Repository
@Transactional
public class AdminDao {

    private SessionFactory sessionFactory;

    @Autowired
    AdminDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Admin> findOne(Admin admin){

        return  sessionFactory.getCurrentSession().createQuery("from Admin Administrator where Administrator.name='" + admin.getName() + "' and Administrator.password='" + admin.getPassword() + "'").list();
    }
}