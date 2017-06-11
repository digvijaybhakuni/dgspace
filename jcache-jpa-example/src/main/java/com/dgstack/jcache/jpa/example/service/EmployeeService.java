/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.service;

import com.dgstack.jcache.jpa.example.model.Employee;
import java.util.List;
import javax.persistence.Cacheable;

/**
 *
 * @author digvijayb
 */
public class EmployeeService {
    
    public Employee getEmployeeById(){
        return null;
    }
    
    public List<Employee> getEmployeeByName(final String name){
        return null;
    }
    
    public Employee save(final Employee e){
        return e;
    }
    
}
