package com.tw.web;

import com.tw.core.UsersService;
import com.tw.core.entity.Role;
import com.tw.core.entity.User;
import com.tw.core.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by hgwang on 5/12/15.
 */

@RestController
@RequestMapping("/receipt")
public class receiptController {

    private ReceiptService receiptService;
    private UsersService usersService;

    @Autowired
    public receiptController(ReceiptService receiptService, UsersService usersService) {
        this.receiptService = receiptService;
        this.usersService = usersService;
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=text/plain", produces="text/plain; charset=UTF-8")
    public Set<Role> getRoles(){
        User user = usersService.findOne(1);

        System.out.println(user + "=========");
        System.out.println(user.getId() + "=========");
        System.out.println(user.getRoles().size() + "=========");

        return user.getRoles();
    }

//    @RequestMapping(method = RequestMethod.GET, headers = "Accept=text/plain", produces="text/plain; charset=UTF-8")
//    public String getReceiptWithText(){
//        return receiptService.getReceiptWithText();
//    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=Application/xml", produces="Application/xml; charset=UTF-8")
    public ModelAndView getReceiptWithView(HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("receipt");
        modelAndView.addObject("receipt", receiptService.getReceipt());
        modelAndView.addObject("itemInCart", receiptService.getReceipt().get("itemsInCart"));

        response.setContentType("application/xml; charset=utf-8");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=Application/json", produces="Application/json; charset=UTF-8")
    public Map getReceiptWithJson(){
        return receiptService.getReceipt();
    }
}
