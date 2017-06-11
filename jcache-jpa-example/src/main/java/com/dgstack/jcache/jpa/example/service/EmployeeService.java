/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.service;

import com.dgstack.jcache.jpa.example.model.Employee;
import java.util.List;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

/**
 *
 * @author digvijayb
 */
public class EmployeeService {
    
    @CacheResult(cacheName = "employee")
    public Employee getEmployeeById(@CacheKey final Long id){
        return null;
    }
    
    @CacheResult(cacheName = "employeesByName")
    public List<Employee> getEmployeeByName(@CacheKey final String name){
        return null;
    }
    
    @CachePut(cacheName = "employees")
    public Employee save(@CacheValue final Employee e){
        return e;
    }
    
}
