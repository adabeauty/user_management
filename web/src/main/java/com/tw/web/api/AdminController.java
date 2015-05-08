package com.tw.web.api;

import com.tw.core.Admin;
import com.tw.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hgwang on 5/7/15.
 */

@RestController
@Scope("session")
@RequestMapping("/api/admins")
public class AdminController {

    private AdminService adminService;

    @Autowired
    AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean findOne(@RequestBody Admin admin, HttpServletRequest request){

        List<Admin> admins = adminService.findOne(admin);
        if(admins.size() != 0){
            request.getSession().setAttribute("admin", admins.get(0));
            return true;
        }else{
            return false;
        }
    }
}