package com.tw.web.api;

import com.tw.core.Admin;
import com.tw.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hgwang on 5/7/15.
 */

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private AdminService adminService;

    @Autowired
    AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean findOne(@RequestBody Admin admin){
        System.out.println(admin);

        return adminService.findOne(admin);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String  sayHello(){
        return "hello";
    }
}