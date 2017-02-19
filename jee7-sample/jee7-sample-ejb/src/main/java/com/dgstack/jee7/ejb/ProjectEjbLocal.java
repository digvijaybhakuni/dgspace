/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7.ejb;

import javax.ejb.Local;

/**
 *
 * @author digvijayb
 */
//@Local
public interface ProjectEjbLocal {

    boolean addProject(final String name);

    String getAllProject();
    
}
