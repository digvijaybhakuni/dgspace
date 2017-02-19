/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    
    public void businessMethod() {
        
        System.out.println("businessMethod");
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Integer testService() {
        return null;
    }

}
