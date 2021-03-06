package com.tw.core;

import com.tw.core.entity.Role;
import com.tw.core.entity.Url;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/24/14.
 */
@Service
public class UsersService {
    private UsersDAO usersDAO;

    @Autowired
    public UsersService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Transactional
    public List<User> findAll() {
        return usersDAO.findAll();
    }

    @Transactional
    public User findOne(int id) {
        return usersDAO.findOne(id);
    }

    @Transactional
    public void create(User user) {
        usersDAO.create(user);
    }

    @Transactional
    public void delete(int id) {
        usersDAO.delete(id);
    }

    @Transactional
    public void update(User user) {
        usersDAO.update(user);
    }

    @Transactional
    public void deleteAll(int[] idList) {
        usersDAO.deleteAll(idList);
    }

    @Transactional
    public List<User> search(String keyword) {
        return usersDAO.search(keyword);
    }

    @Transactional
    public List<User> logIn(User user){
        return usersDAO.logIn(user);
    }

    @Transactional
    public List<Role> getRoles(User user){
        return usersDAO.getRoles(user);
    }

    @Transactional
    public List<Url> getUrls(User user){
        return usersDAO.getUrls(user);
    }
}
