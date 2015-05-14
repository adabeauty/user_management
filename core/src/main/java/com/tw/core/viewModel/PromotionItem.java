package com.tw.core.viewModel;

/**
 * Created by hgwang on 5/14/15.
 */
public class PromotionItem {

    private String name;
    private int count;
    private String countUnit;

    public PromotionItem() {
    }

    public PromotionItem(String name, int count, String countUnit) {
        this.name = name;
        this.count = count;
        this.countUnit = countUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCountUnit() {
        return countUnit;
    }

    public void setCountUnit(String countUnit) {
        this.countUnit = countUnit;
    }
}
