package com.tw.core;

import com.tw.core.entity.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 5/12/15.
 */

@Repository
public class ItemsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ItemsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Item> getAllItems(){
        return sessionFactory.getCurrentSession().createQuery("from Item").list();
    }
}
