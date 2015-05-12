package com.tw.web.api;

import com.tw.core.PromotionsService;
import com.tw.core.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hgwang on 5/12/15.
 */
@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionsController {

    private PromotionsService promotionsService;

    @Autowired
    public PromotionsController(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Promotion promotion){
        promotionsService.create(promotion);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Promotion> getAllPromotions(){
        return promotionsService.getAllPromotions();
    }
}