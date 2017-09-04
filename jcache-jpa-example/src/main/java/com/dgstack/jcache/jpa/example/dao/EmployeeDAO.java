/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.dao;

import com.dgstack.jcache.jpa.example.PersistenceManager;
import com.dgstack.jcache.jpa.example.model.Employee;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
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
@Named
public class EmployeeDAO {
    
    private EntityManagerFactory emf;
    
    public EmployeeDAO(){
        emf = PersistenceManager.INSTANCE.getEntityManagerFactory();
    }
    
        
    
    public List<Employee> findByName(final String name){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        final Query query = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name");
        query.setParameter("name", name);
        List resultList = query.getResultList();
        transaction.commit();
        return  resultList;
    } 
    
    
    public Employee save(final Employee e){
        EntityManager em = emf.createEntityManager();       
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        em.flush();
        transaction.commit();
        return e;
    }
    
    public Employee update(final Employee e){
        EntityManager em = emf.createEntityManager();       
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        em.flush();
        transaction.commit();
        return e;
    }

    public Employee findById(final Integer id) {
        EntityManager em = emf.createEntityManager();       
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee e = em.find(Employee.class, id);
        transaction.commit();
        return e;
    }
    
    
}
