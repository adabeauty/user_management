package com.tw.core.viewModel;

/**
 * Created by hgwang on 5/14/15.
 */
public class PrintedCartItem {

    private String name;
    private int count;
    private String countUnit;
    private double price;
    private String currencyUnit;
    private double subTotal;

    public PrintedCartItem() {
    }

    public PrintedCartItem(String name, int count, String countUnit, double price, String currencyUnit, double subTotal) {
        this.name = name;
        this.count = count;
        this.countUnit = countUnit;
        this.price = price;
        this.currencyUnit = currencyUnit;
        this.subTotal = subTotal;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
