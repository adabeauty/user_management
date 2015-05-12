package com.tw.web.api;

import com.tw.core.PromotionsService;
import com.tw.core.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public void create(Promotion promotion){
        promotionsService.create(promotion);
    }
}
