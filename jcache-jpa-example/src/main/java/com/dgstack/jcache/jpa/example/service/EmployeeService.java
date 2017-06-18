/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.service;

import com.dgstack.jcache.jpa.example.cacheconfig.EmployeeIdCacheKeyGenerator;
import com.dgstack.jcache.jpa.example.cacheconfig.EmployeeNameCacheKeyGenerator;
import com.dgstack.jcache.jpa.example.dao.EmployeeDAO;
import com.dgstack.jcache.jpa.example.model.Employee;
import java.util.List;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author digvijayb
 */
@Stateless
public class EmployeeService {
    
    @Inject
    private EmployeeDAO employeeDAO;
    
    public EmployeeService(){
        System.out.println("EmployeeService()");
                
    }
    
    @CacheResult(cacheName = "employee", cacheKeyGenerator = EmployeeIdCacheKeyGenerator.class)
    public Employee getEmployee(@CacheKey final Integer id){
        return  employeeDAO.findById(id);
    }
    
    @CacheResult(cacheName = "employeesByName", cacheKeyGenerator = EmployeeNameCacheKeyGenerator.class)
    public List<Employee> getEmployeeByName(@CacheKey final String name){
        System.out.println("from db");
        return employeeDAO.findByName(name);
    }
    
    //@CachePut(cacheName = "employee", cacheKeyGenerator = EmployeeIdCacheKeyGenerator.class, afterInvocation = true)
    @CacheRemove(cacheName = "employeesByName", cacheKeyGenerator = EmployeeNameCacheKeyGenerator.class, afterInvocation = true)
    public Employee save(@CacheKey final Employee e){
        return employeeDAO.save(e);
    }
    
    
    
    
}
