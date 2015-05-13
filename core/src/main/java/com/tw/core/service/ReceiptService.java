package com.tw.core.service;

import com.tw.core.ItemsDAO;
import com.tw.core.entity.Item;
import com.tw.core.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hgwang on 5/12/15.
 */

@Service
@Transactional
public class ReceiptService {

    private ItemsDAO itemsDAO;

    @Autowired
    public ReceiptService(ItemsDAO itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Transactional
    public List<Map> getReceipt(List<Item> items, List<Promotion> promotions){

        List<Map> receipt = new ArrayList<Map>();

        for(int i=0; i<items.size(); i++){

            Map itemMap = new HashMap();
            List<Promotion> currentPromotion = new ArrayList<Promotion>();
            for(int j=0; j<promotions.size(); j++){

                if(hasPromotion(items.get(i), promotions.get(j))){
                    currentPromotion.add(promotions.get(j));
                }
            }
            itemMap.put("item", items.get(i));
            itemMap.put("promotions", currentPromotion);

            receipt.add(itemMap);
        }

        return receipt;
    }

    private boolean hasPromotion(Item item, Promotion promotion){

        List<Item> items = itemsDAO.getItemByPromotionAndName(item, promotion);

        if(items.size() == 0){
            return false;
        }
        return true;
    }
}
