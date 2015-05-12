package com.tw.core;

import com.tw.core.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    public void create(Promotion promotion){
        promotionsDAO.create(promotion);
    }

    @Transactional
    public List<Promotion> getAllPromotions(){
        return promotionsDAO.getAllPromotions();
    }
}
