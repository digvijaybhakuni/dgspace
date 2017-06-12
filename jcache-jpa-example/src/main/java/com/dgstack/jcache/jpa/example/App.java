package com.dgstack.jcache.jpa.example;

import com.dgstack.jcache.jpa.example.model.Employee;
import javax.persistence.EntityManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author digvijayb
 */
public class App {
    
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setId(1);
        e.setName("Test");
        e.setDepartment("DEPT");
        
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        entityManager.close();
        PersistenceManager.INSTANCE.close();
    }
}
