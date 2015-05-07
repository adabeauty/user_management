package com.tw.core.service;

import com.tw.core.Admin;
import com.tw.core.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by hgwang on 5/7/15.
 */

@Service
public class AdminService {
    private AdminDao adminDao;

    @Autowired
    AdminService(AdminDao adminDao){
        this.adminDao = adminDao;
    }

    @Transactional
    public Boolean findOne(Admin admin){

        Admin adminTemp = adminDao.findOne(admin);
        if(adminTemp == null){
            return false;
        }else{
            return true;
        }
    }
}
