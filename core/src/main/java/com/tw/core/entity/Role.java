package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 5/10/15.
 */

@Entity
@Table(name="role")
public class Role {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="NAME")
    private String name;

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
}
