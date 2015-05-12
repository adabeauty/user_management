package com.tw.core;

import com.tw.core.entity.Promotion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by hgwang on 5/12/15.
 */

@Repository
@Transactional
public class PromotionsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public PromotionsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Promotion promotion){
        sessionFactory.getCurrentSession().save(promotion);
    }
}
