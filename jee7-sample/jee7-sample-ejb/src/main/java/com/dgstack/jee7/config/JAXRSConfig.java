/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7.config;

import com.dgstack.jee7.restapi.Projects;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author digvijayb
 */
@ApplicationPath("api")
public class JAXRSConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        System.out.println("Classes : Set<Class<?>>");
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(Projects.class);
        return resources;
    }

}
