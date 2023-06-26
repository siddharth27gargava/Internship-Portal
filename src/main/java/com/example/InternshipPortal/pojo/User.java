/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.InternshipPortal.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import org.springframework.stereotype.Component;

/**
 *
 * @author siddh
 */
@Component
@Entity
@Table(name="User")
@PrimaryKeyJoinColumn(name = "accountId")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int accountId;
    
    @Column
    private String username;
    
    @Column
    private String password;
    
    @Column
    private String role;

    public User() {
    }

    public User(int accountId, String username, String password, String role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
