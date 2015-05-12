package com.tw.core;

import com.tw.core.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hgwang on 5/12/15.
 */

@Service
public class ItemsService {

    private ItemsDAO itemsDAO;

    @Autowired
    public ItemsService(ItemsDAO itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Transactional
    public List<Item> getAllItems(){
        return itemsDAO.getAllItems();
    }
}
