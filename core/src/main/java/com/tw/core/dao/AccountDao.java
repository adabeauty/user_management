package com.tw.core.dao;

import com.tw.core.Account;
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
public class AccountDao {

    private SessionFactory sessionFactory;

    @Autowired
    AccountDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Account> findOne(Account account){

        return  sessionFactory.getCurrentSession().createQuery("from Account Account where Account.name='" + account.getName() + "' and Account.password='" + account.getPassword() + "'").list();

    }
}