package com.tw.core.entity;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by twer on 7/16/14.
 */
@Entity
@Table(name = "USER")
@Scope("session")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "AGE")
    private int age;

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = {@JoinColumn(name="USER_ID", nullable=false)},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID", nullable=false)}
    )
    private Set<Role> roles = new HashSet<Role>();

    public User() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
