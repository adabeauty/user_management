package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 5/12/15.
 */

@Entity
@Table(name="item")
public class Item {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private double price;

    @Column(name="UNIT")
    private String unit;

    @Column(name="CREATE_DATE")
    private String create_data;

    @Column(name="BRAND")
    private String brand;

    @Column(name="CATEGORY")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCreate_data() {
        return create_data;
    }

    public void setCreate_data(String create_data) {
        this.create_data = create_data;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String band) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}