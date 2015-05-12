package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 5/12/15.
 */

@Entity
@Table(name="promotion")
public class Promotion {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="TYPE")
    private String type;

    @Column(name="EXPRESSION")
    private String expression;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
