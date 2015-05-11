package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 5/11/15.
 */

@Entity
@Table(name="account_role")
public class AccountAndRole {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="ROLE_ID")
    private int roleId;

    @Column(name="ACCOUNT_ID")
    private int accountId;

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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
