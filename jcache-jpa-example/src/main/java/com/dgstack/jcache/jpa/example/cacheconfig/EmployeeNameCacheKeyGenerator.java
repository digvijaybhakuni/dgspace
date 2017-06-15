/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.cacheconfig;

import com.dgstack.jcache.jpa.example.model.Employee;
import java.lang.annotation.Annotation;
import javax.cache.annotation.CacheInvocationParameter;
import javax.cache.annotation.CacheKeyGenerator;
import javax.cache.annotation.CacheKeyInvocationContext;
import javax.cache.annotation.GeneratedCacheKey;
import org.jsr107.ri.annotations.DefaultGeneratedCacheKey;

/**
 *
 * @author dbhakuni
 */
public class EmployeeNameCacheKeyGenerator implements CacheKeyGenerator{

        @Override
        public GeneratedCacheKey generateCacheKey(CacheKeyInvocationContext<? extends Annotation> cacheKeyInvocationContext) {
            
            final CacheInvocationParameter[] params = cacheKeyInvocationContext.getAllParameters();
            for(final CacheInvocationParameter param : params){
                if(Employee.class.equals(param.getRawType())){
                    final String name = Employee.class.cast(param).getName();
                    return new DefaultGeneratedCacheKey(new Object[]{ name });
                }
            }
            throw new UnsupportedOperationException("Not supported yet."); 
        }
        
    }
