/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.cacheconfig;

import com.dgstack.jcache.jpa.example.model.Employee;
import java.lang.annotation.Annotation;
import java.util.logging.Logger;
import javax.cache.annotation.CacheInvocationParameter;
import javax.cache.annotation.CacheKeyGenerator;
import javax.cache.annotation.CacheKeyInvocationContext;
import javax.cache.annotation.GeneratedCacheKey;
import org.jsr107.ri.annotations.DefaultGeneratedCacheKey;

/**
 *
 * @author digvijayb
 */
public class EmployeeIdCacheKeyGenerator implements CacheKeyGenerator {

    private final static Logger LOG = Logger.getLogger("EmployeeIdCacheKeyGenerator");

    @Override
    public GeneratedCacheKey generateCacheKey(CacheKeyInvocationContext<? extends Annotation> cacheKeyInvocationContext) {

        final CacheInvocationParameter[] params = cacheKeyInvocationContext.getAllParameters();
        for (final CacheInvocationParameter param : params) {
            if (Employee.class.equals(param.getRawType())) {
                final Integer id = Employee.class.cast(param.getValue()).getId();
                return new DefaultGeneratedCacheKey(new Object[]{id});
            } else if (Integer.class.equals(param.getRawType())) {
                Integer id = (Integer) param.getValue();
                return new DefaultGeneratedCacheKey(new Object[]{id});
            }
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
