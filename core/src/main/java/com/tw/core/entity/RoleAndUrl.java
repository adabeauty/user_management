package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 5/11/15.
 */

@Entity
@Table(name="role_url")
public class RoleAndUrl {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="ROLE_ID")
    private int roleId;

    @Column(name="URL_ID")
    private int urlId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }
}

