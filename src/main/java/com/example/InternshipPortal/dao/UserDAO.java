/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.InternshipPortal.dao;



import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.example.InternshipPortal.pojo.User;

/**
 *
 * @author siddh
 */
@Component
public class UserDAO extends DAO{
    public void save(User user) {
        begin();
        getSession().save(user);
        commit();
    }
    
    public void update(User user) {
        try {
            begin();
            getSession().update(user);
            commit();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void delete(User user) {
        begin();
        getSession().delete(user);
        commit();
    }
    
    public User user(int aid) {
        User user = getSession().get(User.class, aid);
        return user;
    }
    
    public User findByUsernameAndPassword(String username, String password) {
        Query query = getSession().createQuery("from User where username=:username and password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);

        User user = (User) query.uniqueResult();
        return user;
    }

    public void AddNewUser(String username, String password, String role) {
        begin();
        System.out.println("inside DAO");

	User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        
        getSession().save(user);
        commit();
    }
}
