package com.tw.core;

import com.sun.webkit.network.URLs;
import com.tw.core.entity.Role;
import com.tw.core.entity.Url;
import com.tw.core.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/24/14.
 */
@Repository
@Transactional
public class UsersDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UsersDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    public User findOne(long id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void delete(long id) {
        User user = findOne(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteAll(long[] idList) {
        for (long id : idList) {
            delete(id);
        }
    }

    public List<User> search(String keyword) {
        String query = "FROM User WHERE name LIKE :keyword or email LIKE :keyword";

        return sessionFactory.getCurrentSession().createQuery(query)
                .setString("keyword", "%" + keyword + "%")
                .list();
    }

    public List<User> logIn(User user){

        return  sessionFactory.getCurrentSession().createQuery("from User user where user.name='" + user.getName() + "' and user.password='" + user.getPassword() + "'").list();
    }


    public void setRoles(User user){
        List<Object> roleIds = sessionFactory.getCurrentSession().createQuery("select relationship.roleId from UserAndRole relationship where relationship.userId='" + user.getId() + "'").list();
        List<Role> roles = sessionFactory.getCurrentSession().createQuery("from Role role where role.id in '" + roleIds + "'").list();

        user.setRoles(roles);
    }

    public void setUrls(User user){

        List<Object> roleIds = sessionFactory.getCurrentSession().createQuery("select relationship.roleId from UserAndRole relationship where relationship.userId='" + user.getId() + "'").list();

        List<Object> urlIds = sessionFactory.getCurrentSession().createQuery("select relationship.urlId from RoleAndUrl relationship where relationship.roleId in '" + roleIds + "'").list();
        List<Url> urls = sessionFactory.getCurrentSession().createQuery("from Url url where url.id in '" + urlIds +"'").list();

        user.setUrls(urls);
    }
//    public List<Url> getUrls(User user){
//
//        List<Object> roleIds = sessionFactory.getCurrentSession().createQuery("select relationship.roleId from UserAndRole relationship where relationship.userId='" + user.getId() + "'").list();
//        List<Object> urlIds = sessionFactory.getCurrentSession().createQuery("select relationship.urlId from RoleAndUrl relationship where relationship.roleId in '" + roleIds + "'").list();
//
//        return  sessionFactory.getCurrentSession().createQuery("from Url url where url.id in '" + urlIds +"'").list();
//    }
}