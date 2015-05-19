package com.tw.core.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<User>();

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
