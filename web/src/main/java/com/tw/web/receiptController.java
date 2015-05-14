package com.tw.web;

import com.tw.core.ItemsService;
import com.tw.core.PromotionsService;
import com.tw.core.entity.Item;
import com.tw.core.entity.Promotion;
import com.tw.core.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by hgwang on 5/12/15.
 */

@RestController
@RequestMapping("/receipt")
public class receiptController {

    private PromotionsService promotionsService;
    private ReceiptService receiptService;
    private ItemsService itemsService;

    @Autowired
    public receiptController(PromotionsService promotionsService, ReceiptService receiptService, ItemsService itemsService) {
        this.promotionsService = promotionsService;
        this.receiptService = receiptService;
        this.itemsService = itemsService;
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public List<Map> getItemsWithPromotion() {

        List<Item> items = itemsService.getAllItems();
        List<Promotion> promotions = promotionsService.getAllPromotions();

        return receiptService.getItemsWithPromotion(items, promotions);
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=text/plain", produces="text/plain; charset=UTF-8")
    public String getReceiptWithText(){
        return receiptService.getReceiptWithText();
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=Application/xml")
    public ModelAndView getReceiptWithView(){
        ModelAndView modelAndView = new ModelAndView("receipt");

        List<Item> items = itemsService.getAllItems();
        List<Promotion> promotions = promotionsService.getAllPromotions();

//        List<Map> receipt = receiptService.getReceipt(items, promotions);

//        modelAndView.addObject("receipt", receipt);
        return modelAndView;
    }

}
