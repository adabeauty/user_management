package com.tw.core;

import com.tw.core.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hgwang on 5/12/15.
 */

@Service
public class PromotionsService {

    private PromotionsDAO promotionsDAO;

    @Autowired
    public PromotionsService(PromotionsDAO promotionsDAO) {
        this.promotionsDAO = promotionsDAO;
    }

    public void create(Promotion promotion){
        promotionsDAO.create(promotion);
    }
}
