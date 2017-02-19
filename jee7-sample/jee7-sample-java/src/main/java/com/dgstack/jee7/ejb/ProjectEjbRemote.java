/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7.ejb;

import javax.ejb.Remote;

/**
 *
 * @author digvijayb
 */
//@Remote
public interface ProjectEjbRemote {

    boolean addProject(final String name);
    
}
