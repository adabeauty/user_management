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

    public User findOne(int id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void delete(int id) {
        User user = findOne(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteAll(int[] idList) {
        for (int id : idList) {
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

        return  sessionFactory.getCurrentSession().createQuery("from User as user where user.name='" + user.getName() + "' and user.password='" + user.getPassword() + "'").list();
    }


    public List<Role> getRoles(User user){
        
        return sessionFactory.getCurrentSession().createQuery("from Role as role where role.id " +
                "in (select relationship.roleId from UserAndRole as relationship where relationship.userId = :userId)").setParameter("userId", user.getId()).list();
    }

    public List<Url> getUrls(User user){

        return sessionFactory.getCurrentSession().createQuery("from Url url where url.id " +
                "in (select relationship.urlId from RoleAndUrl as relationship where relationship.roleId " +
                "in (select relationship.roleId from UserAndRole as relationship where relationship.userId = :userId))").setParameter("userId", user.getId()).list();
    }
}