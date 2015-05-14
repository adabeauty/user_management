package com.tw.core.service;

import com.tw.core.ItemsDAO;
import com.tw.core.PromotionsDAO;
import com.tw.core.entity.Item;
import com.tw.core.entity.Promotion;
import com.tw.core.model.CartItem;
import com.tw.core.viewModel.PrintedCartItem;
import com.tw.core.viewModel.PromotionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hgwang on 5/12/15.
 */

@Service
@Transactional
public class ReceiptService {

    private ItemsDAO itemsDAO;
    private PromotionsDAO promotionsDAO;

    @Autowired
    public ReceiptService(ItemsDAO itemsDAO, PromotionsDAO promotionsDAO) {
        this.itemsDAO = itemsDAO;
        this.promotionsDAO = promotionsDAO;
    }


    private List<CartItem> getInputs(){

        List<Item> items = itemsDAO.getAllItems();
        List<Promotion> promotions = promotionsDAO.getAllPromotions();

        List<Map> receipt = this.getItemsWithPromotion(items, promotions);

        List<CartItem> cartItems = new ArrayList<CartItem>();
        for(int i=0; i<receipt.size(); i++){
            CartItem cartItem = new CartItem((Item) receipt.get(i).get("item"), (List<Promotion>)receipt.get(i).get("promotions"), 4);
            cartItems.add(cartItem);
        }

        return cartItems;
    }

    private String getDate(){
        Date date = new Date();
        SimpleDateFormat timeFormater=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return timeFormater.format(date);
    }

    private String getPromotions(List<CartItem> cartItems){

        String promotions = "----------------------" + "\n"
                + "挥泪赠送商品：" + "\n";

        for(int i=0; i<cartItems.size(); i++){
            if(cartItems.get(i).getPromotions().size() != 0){
                CartItem cartItem = cartItems.get(i);
                promotions += "名称：" + cartItem.getItem().getName() + "，"
                        + "数量：" + cartItem.getPromotionNumber() + cartItem.getItem().getUnit() + "\n";
            }
        }

        return promotions;
    }

    private String getFooter(List<CartItem> cartItems){
        String footer = "----------------------" + "\n"
                + "总计：" + this.getDataOfFooter(cartItems).get("total") + "（元）" + "\n"
                + "优惠：" + this.getDataOfFooter(cartItems).get("savedMoney") + "（元）" +"\n"
                + "**********************";

        return footer;
    }

    private String getTextOfCartItems(List<CartItem> cartItems){

        String text = "";
        for (int i=0; i<cartItems.size(); i++){
            CartItem cartItem = cartItems.get(i);
            text += "名称：" + cartItem.getItem().getName() + "，"
                    + "数量：" + cartItem.getNumber() + cartItem.getItem().getUnit() + "，"
                    + "单价：" + cartItem.getItem().getPrice() + "（元），"
                    + "小计：" + cartItem.getSubtotal() + "（元）" + "\n";
        }
        return text;
    }

    private Map getDataOfFooter(List<CartItem> cartItems){

        double total = 0;
        double savedMoney = 0;

        Map map = new HashMap();
        for (int i=0; i<cartItems.size(); i++){
            total += cartItems.get(i).getSubtotal();
            savedMoney += cartItems.get(i).getSavedMoney();
        }

        map.put("total", total);
        map.put("savedMoney", savedMoney);

        return map;
    }

    private boolean hasPromotion(Item item, Promotion promotion){

        List<Item> items = itemsDAO.getItemByPromotionAndName(item, promotion);

        if(items.size() == 0){
            return false;
        }
        return true;
    }

    private List<PromotionItem> getPresents(List<CartItem> cartItems){

        List<PromotionItem> presents = new ArrayList<PromotionItem>();

        for(int i=0; i<cartItems.size(); i++){
            if(cartItems.get(i).getPromotions().size() != 0){
                CartItem cartItem = cartItems.get(i);

                PromotionItem promotionItem = new PromotionItem(
                        cartItem.getItem().getName(), cartItem.getPromotionNumber(), cartItem.getItem().getUnit()
                );
                promotionItem.setName(cartItem.getItem().getName());
                presents.add(promotionItem);
            }
        }

        return presents;
    }

    private List<PrintedCartItem> getPrintedCartItems(List<CartItem> cartItems){

        List<PrintedCartItem> printCartItems = new ArrayList<PrintedCartItem>();

        for (int i=0; i<cartItems.size(); i++){
            CartItem cartItem = cartItems.get(i);

            PrintedCartItem printedCartItem = new PrintedCartItem(
                    cartItem.getItem().getName(), cartItem.getNumber(), cartItem.getItem().getUnit(), cartItem.getItem().getPrice(), "元", cartItem.getSubtotal()
            );

            printCartItems.add(printedCartItem);
        }
        return printCartItems;
    }
    
    @Transactional
    public List<Map> getItemsWithPromotion(List<Item> items, List<Promotion> promotions){

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

    @Transactional
    public String getReceiptWithText(){

        String title = "***<没钱赚商店>购物清单***" + "\n"
                + "打印时间" + this.getDate() + "\n"
                + "----------------------" + "\n";

        List<CartItem> cartItems = this.getInputs();

        return title + getTextOfCartItems(cartItems) + this.getPromotions(cartItems) + this.getFooter(cartItems);
    }

    @Transactional
    public Map getReceipt(){

        Map receiptMap = new HashMap();

        receiptMap.put("name", "购物清单");
        receiptMap.put("printDate", this.getDate());
        receiptMap.put("storeName", "没钱赚商店");

        List<CartItem> cartItems = this.getInputs();

        receiptMap.put("itemsInCart", this.getPrintedCartItems(cartItems));

        receiptMap.put("total", this.getDataOfFooter(cartItems));
        receiptMap.put("presents", this.getPresents(cartItems));

        return receiptMap;
    }
}