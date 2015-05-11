package com.tw.web.api;

import com.tw.core.UsersService;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hgwang on 5/7/15.
 */

@RestController
@Scope("session")
@RequestMapping("/api/session")
public class LogController {

    private UsersService usersService ;

    @Autowired
    LogController(UsersService usersService){
        this.usersService = usersService;
    }

    private Map getUser(User user){

        List<User> users = usersService.logIn(user);

        Map userMap = new HashMap();
        userMap.put("user", users.get(0));
        userMap.put("urls", usersService.getUrls(users.get(0)));

        return userMap;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String findOne(@RequestBody User user, HttpServletRequest request){

        Object session  = request.getSession().getAttribute("current_user");
        List<User> users = usersService.logIn(user);

        if(users.size() != 0){
            if(session == null) {

                request.getSession().setAttribute("current_user", this.getUser(user));
                return "登录成功";
            }else{
                return "用户已登录";
            }
        }else{
            return "用户名或密码错误";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map isLogIn(HttpServletRequest request){

        Object session  = request.getSession().getAttribute("current_user");
        if(session != null){
            return (Map) session;
        }else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void clearSession(HttpServletRequest request){
        request.getSession().removeAttribute("current_user");
    }
}