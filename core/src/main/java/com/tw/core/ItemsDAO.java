package com.tw.core;

import com.tw.core.entity.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hgwang on 5/12/15.
 */

@Repository
@Transactional
public class ItemsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ItemsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Item> getAllItems(){
        return sessionFactory.getCurrentSession().createQuery("from Item").list();
    }
}
