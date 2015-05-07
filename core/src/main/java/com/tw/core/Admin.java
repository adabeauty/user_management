package com.tw.core;

import javax.persistence.*;

/**
 * Created by hgwang on 5/7/15.
 */

@Entity
@Table(name = "ADMINISTRATOR")
public class Admin {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "")
    private String name;

    @Column(name = "")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
