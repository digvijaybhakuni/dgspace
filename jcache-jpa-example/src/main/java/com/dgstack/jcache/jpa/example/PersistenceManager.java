/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author digvijayb
 */
public enum PersistenceManager {
    
   INSTANCE;
    
  private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jcache-jpa-example");
  private PersistenceManager() {

  }
  public EntityManager getEntityManager() {
    return emFactory.createEntityManager();
  }
  public void close() {
    emFactory.close();
  }

    public EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }
}
