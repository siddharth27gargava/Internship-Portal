/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.InternshipPortal.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.springframework.stereotype.Component;


/**
 *
 * @author siddh
 */
@Component
@Entity
@Table(name="Posting")
@PrimaryKeyJoinColumn(name = "jobId")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int jobId;
    
    @Column
    private String position;
    
    @Column
    private String company;
    
    @Column
    private Date startDate;
    
    @Column
    private float stipend;
    
    @Column
    private String location;
    
    @Column
    private int weeklyHours;

    public Posting() {
    }

    public Posting(String position, Date startDate, float stipend, String location, int weeklyHours, String company) {
        //this.jobId = jobId;
        this.position = position;
        this.startDate = startDate;
        this.stipend = stipend;
        this.location = location;
        this.weeklyHours = weeklyHours;
        this.company = company;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public float getStipend() {
        return stipend;
    }

    public void setStipend(float stipend) {
        this.stipend = stipend;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
}
