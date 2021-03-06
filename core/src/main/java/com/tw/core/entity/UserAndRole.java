package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 5/11/15.
 */

@Entity
@Table(name="user_role")
public class UserAndRole {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="ROLE_ID")
    private int roleId;

    @Column(name="USER_ID")
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
