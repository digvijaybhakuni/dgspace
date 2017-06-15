/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.service;

import com.dgstack.jcache.jpa.example.cacheconfig.EmployeeNameCacheKeyGenerator;
import com.dgstack.jcache.jpa.example.dao.EmployeeDAO;
import com.dgstack.jcache.jpa.example.model.Employee;
import java.lang.annotation.Annotation;
import java.util.List;
import javax.cache.annotation.CacheInvocationParameter;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheKeyGenerator;
import javax.cache.annotation.CacheKeyInvocationContext;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;
import javax.cache.annotation.GeneratedCacheKey;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.jsr107.ri.annotations.DefaultCacheKeyGenerator;
import org.jsr107.ri.annotations.DefaultGeneratedCacheKey;

/**
 *
 * @author digvijayb
 */
@Stateless
public class EmployeeService {
    
    @Inject
    private EmployeeDAO employeeDAO;
    
    @CacheResult(cacheName = "employeesByName")
    public List<Employee> getEmployeeByName(@CacheKey final String name){
        System.out.println("from db");
        return employeeDAO.findByName(name);
    }
    
    //@CachePut(cacheName = "employeesByName", cacheKeyGenerator = EmployeeNameCacheKeyGenerator.class)
    //public Employee save(@CacheKey @CacheValue final Employee e){
    @CacheRemoveAll(cacheName = "employeesByName")
    public Employee save(final Employee e){
        return employeeDAO.save(e);
    }
    
    
    
    
}
