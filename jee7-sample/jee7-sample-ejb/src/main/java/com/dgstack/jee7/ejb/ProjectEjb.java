/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author digvijayb
 */
@Stateless @LocalBean
public class ProjectEjb {

    private static final List<String> LST_PROJECTS = new ArrayList<>();
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public boolean addProject(final String name) {
        LST_PROJECTS.add(name);
        return true;
    }

    public List<String> getAllProject() {
        return new ArrayList<>(LST_PROJECTS);
    }
    
    
}
