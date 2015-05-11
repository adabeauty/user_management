package com.tw.web.api;

import com.tw.core.entity.Account;
import com.tw.core.service.AccountService;
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
@RequestMapping("/api/session")
public class AccountController {

    private AccountService accountService;

    @Autowired
    AccountController(AccountService adminService){
        this.accountService = adminService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String findOne(@RequestBody Account admin, HttpServletRequest request){

        Object session  = request.getSession().getAttribute("current_user");

        List<Account> admins = accountService.findOne(admin);

        if(admins.size() != 0){
            if(session == null){
                request.getSession().setAttribute("current_user", admins.get(0));

                return "登录成功";
            }else{
                return "用户已登录";
            }
        }else{
            return "用户名或密码错误";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Account isLogIn(HttpServletRequest request){

        Object session  = request.getSession().getAttribute("current_user");
        if(session != null){
            return (Account) session;
        }else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void clearSession(HttpServletRequest request){
        request.getSession().removeAttribute("current_user");
    }
}