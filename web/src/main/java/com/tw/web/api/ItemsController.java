package com.tw.web.api;

import com.tw.core.ItemsService;
import com.tw.core.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hgwang on 5/12/15.
 */

@RestController
@RequestMapping("/api/v1/items")
public class ItemsController {

    private ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getAllItems(){
        return itemsService.getAllItems();
    }
}