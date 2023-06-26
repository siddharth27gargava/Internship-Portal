/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.InternshipPortal.controller;


import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.InternshipPortal.dao.PostingDAO;
import com.example.InternshipPortal.pojo.Posting;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author siddh
 */

@Controller
public class PostingController {
    @GetMapping("/add-get.htm")
    public String addPostingGet(@ModelAttribute Posting posting, BindingResult result, HttpServletRequest request, HttpServletResponse response, PostingDAO postingdao)throws Exception{
        
        return "/addPosting";
    }
    
    @PostMapping("/posting-add.htm")
    public String addPosting(@ModelAttribute Posting posting, BindingResult result, SessionStatus status, PostingDAO postingdao) throws Exception{
        
        postingdao.create(posting);
        
        return "/addPostingSuccess";
    }
    
    @GetMapping("/viewPosting.htm")
    public String viewPostingGet(@ModelAttribute Posting posting, BindingResult result, HttpServletRequest request, HttpServletResponse response, PostingDAO postingdao)throws Exception{
        HttpSession session = request.getSession();
        List<Posting> list = postingdao.list();
        session.setAttribute("postings", list);
        return "/viewPostings";
    }
    
    
    @PostMapping("/searchbylocation.htm")
    public String viewPostingByLocationGet(@ModelAttribute Posting posting, ModelMap model, BindingResult result, HttpServletRequest request, HttpServletResponse response, PostingDAO postingdao)throws Exception{
        HttpSession session = request.getSession();
        System.out.println("*****************SIDDD");
        System.out.println(request.getParameter("radio"));
        if(request.getParameter("radio").equals("location")){
            System.out.println("Inside if loop "+request.getParameter("radio"));
            System.out.println(request.getParameter("radio"));
            System.out.println(request.getParameter("keyword"));
            List<Posting> list = postingdao.search(request.getParameter("radio"),request.getParameter("keyword"));
            model.addAttribute("postings", list);
            return "/viewPostingsByLocation";
        } else if(request.getParameter("radio") == "company"){
            List<Posting> list = postingdao.search(request.getParameter("radio"),request.getParameter("keyword"));
            session.setAttribute("postings", list);
            return "/viewPostingsByLocation";
        } else if(request.getParameter("radio") == "position"){
             List<Posting> list = postingdao.search(request.getParameter("radio"),request.getParameter("keyword"));
            session.setAttribute("postings", list);
            return "/viewPostingsByLocation";
        }
        return "/errorPage";
    }
    
}
