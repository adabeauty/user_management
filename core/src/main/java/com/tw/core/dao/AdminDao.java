package com.tw.core.dao;

import com.tw.core.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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

    public Admin findOne(Admin admin){
        return (Admin) sessionFactory.getCurrentSession().get(Admin.class, admin.getName());
    }
}