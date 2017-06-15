/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.dao;

import com.dgstack.jcache.jpa.example.PersistenceManager;
import com.dgstack.jcache.jpa.example.model.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author digvijayb
 */
@Stateless
public class EmployeeDAO {
    
    
    
    public List<Employee> findByName(final String name){
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        final Query query = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name");
        query.setParameter("name", name);
        
        return  query.getResultList();
    } 
    
    
    public Employee save(final Employee e){
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        em.flush();
        transaction.commit();
        return e;
    }
    
    
}
