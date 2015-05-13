package com.tw.web.api;

import com.tw.core.ItemsService;
import com.tw.core.PromotionsService;
import com.tw.core.entity.Item;
import com.tw.core.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by hgwang on 5/12/15.
 */

@RestController
@RequestMapping("/api/v1/items")
public class ItemsController {

    private ItemsService itemsService;
    private PromotionsService promotionsService;

    @Autowired
    public ItemsController(ItemsService itemsService, PromotionsService promotionsService) {
        this.itemsService = itemsService;
        this.promotionsService = promotionsService;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Item> getAllItems(){
//        return itemsService.getAllItems();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Map> getAllItemsWithPromotion(){

        List<Item> items = itemsService.getAllItems();
        List<Promotion> promotions = promotionsService.getAllPromotions();

        return itemsService.getAllItemsWithPromotion(items, promotions);
    }
}