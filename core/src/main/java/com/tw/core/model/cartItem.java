package com.tw.core.model;

import com.tw.core.entity.Item;
import com.tw.core.entity.Promotion;

import java.util.List;

/**
 * Created by hgwang on 5/13/15.
 */

public class CartItem {

    private String BUY_TREE_FREE_ONE = "买三赠一";

    private Item item;
    private List<Promotion> promotions;
    private int number;

    public CartItem() {
    }

    public CartItem(Item item, List<Promotion> promotions, int number) {
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
        int actualNumber = this.number-getPromotionNumber();
        return actualNumber * this.item.getPrice();
    }

    public double getSavedMoney(){
        double subtotal = this.number * this.item.getPrice();
        return subtotal - this.getSubtotal();
    }

    public int getPromotionNumber(){

        int promotionNumber = 0;
        for(int i=0; i<this.promotions.size(); i++){

            System.out.println(this.promotions.get(i).getType() + "=========");

            if(this.promotions.get(i).getType().equals(this.BUY_TREE_FREE_ONE)){
                promotionNumber += this.number/4;
            }
        }
        return promotionNumber;
    }
}
