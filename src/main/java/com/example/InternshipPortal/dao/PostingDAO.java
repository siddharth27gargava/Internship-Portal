/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.InternshipPortal.dao;


import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.example.InternshipPortal.pojo.Posting;

/**
 *
 * @author siddh
 */

@Component
public class PostingDAO extends DAO{
//    public void create(String position, Date startDate, float stipend, String location, int weeklyHours, String company) {
//        try {
//            //save item object in the database
//        	begin();
//                Posting posting = new Posting(position, startDate, stipend, location, weeklyHours, company);
//        	getSession().save(posting);
//        	commit();
//        	close();
//    
//        } catch (HibernateException e) {
//            rollback();
//            throw new HibernateException("Could not save posting");
//        }
//    }
    
    public void create(Posting posting) {
        try {
            //save item object in the database
        	begin();
                getSession().save(posting);
        	commit();
        	close();
    
        } catch (HibernateException e) {
            rollback();
            throw new HibernateException("Could not save posting");
        }
    }
    
    
    public void delete(Posting posting) {
    	 try {
             //delete item object in the database
         	begin();
         	getSession().delete(posting);
         	commit();
         	
         } catch (HibernateException e) {
             rollback();
             throw new HibernateException("Could not save posting");
         }
    }

    public List<Posting> list() {
        try{
            begin();
            Query query = getSession().createQuery("from Posting");
            List<Posting> list = query.list();
            commit();
            close();
        	
            return list;
    } catch (HibernateException e) {
             rollback();
             throw new HibernateException("Could not save posting");
         }

//		try {
//			begin();
//			// HQL Criteria
//			Criteria criteria = getSession().createCriteria(Posting.class);
//			List<Posting> list = criteria.list();
//			commit();
//			return list;
//		} catch (HibernateException e) {
//			rollback();
//			throw new HibernateException("Could not list Postings");
//		}
    }
    
    public List<Posting> search(String keyword, String location){
             begin();
        	Query query = getSession().createQuery("From Posting where :keyword=:location");
                query.setParameter("keyword", keyword);
                query.setParameter("location", location);
                List<Posting> list = query.list();
        	commit();
        	close();
        	return list;

    }
    
       public int updatePosting(String position, Date startDate, float stipend, String location, int weeklyHours, String company){
   	try{
   		begin();
   		Query query = getSession().createQuery("update Posting set position= :position,startDate= :startDate, stipend =:stipend , location = :location, weeklyHours = :weeklyHours,company = :company");
   		query.setString("position", position);
   		query.setDate("startDate", startDate);
   		query.setFloat("stipend", stipend);
                query.setString("location", location);
                query.setInteger("weeklyHours", weeklyHours);
                query.setString("company",company);
   		
   		System.out.print("updateDAO");
   		int result = query.executeUpdate();
   		commit();
   		return result;
   	}catch(HibernateException e){
   		rollback();
   		return 0;
   	}
   }
       
}
