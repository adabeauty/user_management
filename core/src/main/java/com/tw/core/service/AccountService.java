package com.tw.core.service;

import com.tw.core.Account;
import com.tw.core.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hgwang on 5/7/15.
 */

@Service
public class AccountService {
    private AccountDao accountDao;

    @Autowired
    AccountService(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Transactional
    public List<Account> findOne(Account account){

        return accountDao.findOne(account);
    }
}
