package com.tw.core.model;

import com.tw.core.entity.Item;
import com.tw.core.entity.Promotion;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by hgwang on 5/13/15.
 */
@Entity
public class cartItem {

    private Item item;
    private List<Promotion> promotions;
    private int number;

    public cartItem() {
    }

    public cartItem(Item item, List<Promotion> promotions, int number) {
        this.item = item;
        this.promotions = promotions;
        this.number = number;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSubtotal(){
        return this.number * this.item.getPrice();
    }
}
