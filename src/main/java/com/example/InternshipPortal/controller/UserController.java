/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.InternshipPortal.controller;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.example.InternshipPortal.dao.UserDAO;
import com.example.InternshipPortal.pojo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author siddh
 */
@Controller
public class UserController {
    	
    @RequestMapping(value = "/register-user-get.htm", method = RequestMethod.GET)
    public String registerUserGet(@ModelAttribute User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        return "/register";
    }
        
    @RequestMapping(value = "/register-user.htm", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute User user, BindingResult result, HttpServletRequest request, HttpServletResponse response, SessionStatus status, 
            UserDAO userdao) throws IOException, ServletException{
//        HttpSession session = request.getSession();
//	User sessionUser = (User) session.getAttribute("user");
        
        if (result.hasErrors()) {
            return "/register";
	}
        
        try {

            UserDAO usenter = new UserDAO();
            usenter.AddNewUser(user.getUsername(),user.getPassword(),user.getRole());
		} catch (Exception exp) {
            System.out.println("Exception: " + exp.getMessage());
        }
        return "/login-view";
    }
    
    @RequestMapping(value = "/get-user-logging.htm", method = RequestMethod.GET)
    public String handleLoginGet(@ModelAttribute User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        return "/login-view";
    }
        @RequestMapping(value = "/user-logging.htm", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute User user, BindingResult result, HttpServletRequest request, HttpServletResponse response, SessionStatus status, 
            UserDAO userdao) throws IOException, ServletException{
        HttpSession session = request.getSession();
//        UserDAO userdaoObj = new UserDAO();
        
        User loggedInUser = userdao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        
        if(loggedInUser!=null && loggedInUser.getRole().equals(user.getRole()) && user.getRole().equals("hrexecutiverole")){
            session.setAttribute("user", loggedInUser);
            return "/hrhome";
        } else if(loggedInUser!=null && loggedInUser.getRole().equals(user.getRole()) && user.getRole().equals("studentrole")){
            session.setAttribute("user", loggedInUser);
            return "/studenthome";
        }
        
        return "/login-view";
    }
    

}
